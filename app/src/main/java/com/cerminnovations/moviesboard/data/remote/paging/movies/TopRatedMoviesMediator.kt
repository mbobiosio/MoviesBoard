package com.cerminnovations.moviesboard.data.remote.paging.movies

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.cerminnovations.core.constant.Constants.DEFAULT_PAGE_INDEX
import com.cerminnovations.core.constant.Constants.apiKey
import com.cerminnovations.database.AppDatabase
import com.cerminnovations.database.entities.movies.toprated.TopRatedMovie
import com.cerminnovations.database.entities.movies.toprated.TopRatedRemoteDao
import com.cerminnovations.moviesboard.data.mappers.mapDataToTopRatedMovieEntity
import com.cerminnovations.moviesboard.data.remote.api.ApiService
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@ExperimentalPagingApi
class TopRatedMoviesMediator @Inject constructor(
    private val service: ApiService,
    private val database: AppDatabase
) : RemoteMediator<Int, TopRatedMovie>() {

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, TopRatedMovie>
    ): MediatorResult {
        val page = when (val pageKeyData = getKeyPageData(loadType, state)) {
            is MediatorResult.Success -> return pageKeyData
            else -> pageKeyData as Int
        }

        try {
            val response = service.getTopRatedMovies(
                apiKey = apiKey,
                page = page,
                language = null,
                region = null
            )

            val data = response.mapDataToTopRatedMovieEntity()

            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    database.topRatedMoviesDao.deleteAll()
                    database.topRatedRemoteKeyDao.deleteAllKeys()
                }
                val prevKey = if (page == DEFAULT_PAGE_INDEX) null else page - 1
                val nextKey = if (data.isEndOfListReached) null else page + 1
                val keys = data.results.map {
                    TopRatedRemoteDao(
                        it.movieId,
                        prevKey = prevKey,
                        nextKey = nextKey
                    )
                }

                database.topRatedRemoteKeyDao.insertAll(remoteKeys = keys)
                database.topRatedMoviesDao.insertMovies(data.results)
            }

            return MediatorResult.Success(endOfPaginationReached = data.isEndOfListReached)
        } catch (e: IOException) {
            return MediatorResult.Error(e)
        } catch (e: HttpException) {
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getKeyPageData(
        loadType: LoadType,
        state: PagingState<Int, TopRatedMovie>
    ): Any {
        return when (loadType) {
            LoadType.REFRESH -> {
                val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                remoteKeys?.nextKey?.minus(1) ?: 1
            }
            LoadType.APPEND -> {
                val remoteKeys = getLastRemoteKey(state)
                val nextKey = remoteKeys?.nextKey
                return nextKey ?: MediatorResult.Success(endOfPaginationReached = false)
            }
            LoadType.PREPEND -> {
                val remoteKeys = getFirstRemoteKey(state)
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
        state: PagingState<Int, TopRatedMovie>
    ): TopRatedRemoteDao? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.movieId?.let { id ->
                database.topRatedRemoteKeyDao.remoteKeyId(
                    id
                )
            }
        }
    }

    private suspend fun getLastRemoteKey(state: PagingState<Int, TopRatedMovie>): TopRatedRemoteDao? {
        return state.pages
            .lastOrNull { it.data.isNotEmpty() }
            ?.data?.lastOrNull()
            ?.let { movie -> database.topRatedRemoteKeyDao.remoteKeyId(movie.movieId) }
    }

    private suspend fun getFirstRemoteKey(state: PagingState<Int, TopRatedMovie>): TopRatedRemoteDao? {
        return state.pages
            .firstOrNull { it.data.isNotEmpty() }
            ?.data?.firstOrNull()
            ?.let { movie -> database.topRatedRemoteKeyDao.remoteKeyId(movie.movieId) }
    }
}
