package com.cerminnovations.moviesboard.data.remote.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.cerminnovations.moviesboard.data.local.AppDatabase
import com.cerminnovations.moviesboard.data.local.entities.popular.PopularMovie
import com.cerminnovations.moviesboard.data.local.entities.popular.PopularRemoteKey
import com.cerminnovations.moviesboard.data.mappers.mapDataToPopularMoviesEntity
import com.cerminnovations.moviesboard.data.remote.api.ApiService
import com.cerminnovations.moviesboard.util.Constants.apiKey
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@ExperimentalPagingApi
class PopularMoviesMediator @Inject constructor(
    private val service: ApiService,
    private val database: AppDatabase
) : RemoteMediator<Int, PopularMovie>() {
    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PopularMovie>
    ): MediatorResult {
        val page = when (val pageKeyData = getKeyPageData(loadType, state)) {
            is MediatorResult.Success -> return pageKeyData
            else -> pageKeyData as Int
        }

        try {
            val response = service.getPopularMovies(
                apiKey = apiKey,
                page = page,
                language = null,
                region = null
            )

            val data = response.mapDataToPopularMoviesEntity()

            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    database.popularMoviesDao.deleteAll()
                    database.popularRemoteKeyDao.deleteAll()
                }
                val prevKey = if (page == 1) null else page - 1
                val nextKey = if (data.isEndOfListReached) null else page + 1
                val keys = data.movies.map {
                    PopularRemoteKey(
                        it.movieId,
                        prevKey = prevKey,
                        nextKey = nextKey
                    )
                }
                database.popularRemoteKeyDao.insertAll(keys)
                database.popularMoviesDao.insertMovies(data.movies)
            }
            return MediatorResult.Success(endOfPaginationReached = data.isEndOfListReached)
        } catch (exception: IOException) {
            return MediatorResult.Error(exception)
        } catch (exception: HttpException) {
            return MediatorResult.Error(exception)
        }
    }

    private suspend fun getKeyPageData(
        loadType: LoadType,
        state: PagingState<Int, PopularMovie>
    ): Any {
        return when (loadType) {
            LoadType.REFRESH -> {
                val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                Timber.d("Refresh $remoteKeys")
                remoteKeys?.nextKey?.minus(1) ?: 1
            }
            LoadType.APPEND -> {
                val remoteKeys = getLastRemoteKey(state)
                val nextKey = remoteKeys?.nextKey
                Timber.d("Append $nextKey")
                return nextKey ?: MediatorResult.Success(endOfPaginationReached = false)
            }
            LoadType.PREPEND -> {
                val remoteKeys = getFirstRemoteKey(state)
                Timber.d("Prepend ${remoteKeys?.prevKey}")
                remoteKeys?.prevKey ?: return MediatorResult.Success(
                    endOfPaginationReached = false
                )
            }
            else -> {
                val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                remoteKeys?.nextKey?.minus(1) ?: 1
            }
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, PopularMovie>
    ): PopularRemoteKey? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.movieId?.let { id ->
                database.popularRemoteKeyDao.remoteKeyId(
                    id
                )
            }
        }
    }

    private suspend fun getLastRemoteKey(state: PagingState<Int, PopularMovie>): PopularRemoteKey? {
        return state.pages
            .lastOrNull { it.data.isNotEmpty() }
            ?.data?.lastOrNull()
            ?.let { movie -> database.popularRemoteKeyDao.remoteKeyId(movie.movieId) }
    }

    private suspend fun getFirstRemoteKey(state: PagingState<Int, PopularMovie>): PopularRemoteKey? {
        return state.pages
            .firstOrNull { it.data.isNotEmpty() }
            ?.data?.firstOrNull()
            ?.let { movie -> database.popularRemoteKeyDao.remoteKeyId(movie.movieId) }
    }
}
