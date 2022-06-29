package com.cerminnovations.moviesboard.data.remote.paging.movies

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.cerminnovations.core.constant.Constants.apiKey
import com.cerminnovations.moviesboard.data.local.AppDatabase
import com.cerminnovations.moviesboard.data.local.entities.movies.trending.TrendingMovies
import com.cerminnovations.moviesboard.data.local.entities.movies.trending.TrendingMoviesRemoteKey
import com.cerminnovations.moviesboard.data.mappers.mapDataToTrendingMovieEntity
import com.cerminnovations.moviesboard.data.remote.api.ApiService
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@ExperimentalPagingApi
class TrendingMediator @Inject constructor(
    private val service: ApiService,
    private val database: AppDatabase
) : RemoteMediator<Int, TrendingMovies>() {

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, TrendingMovies>
    ): MediatorResult {
        val page = when (val pageKeyData = getKeyPageData(loadType, state)) {
            is MediatorResult.Success -> return pageKeyData
            else -> pageKeyData as Int
        }

        try {
            val response = service.getTrendingMovies(
                apiKey = apiKey,
                page = page,
                mediaType = "movie",
                timeWindow = "week"
            )

            val data = response.mapDataToTrendingMovieEntity()

            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    database.trendingMoviesRemoteDao.deleteAllKeys()
                    database.trendingMoviesDao.deleteAll()
                }

                val prevKey = if (page == 1) null else page - 1
                val nextKey = if (data.isEndOfListReached) null else page + 1
                val keys = data.movies.map {
                    TrendingMoviesRemoteKey(
                        it.movieId,
                        prevKey = prevKey,
                        nextKey = nextKey
                    )
                }

                database.trendingMoviesRemoteDao.insertAll(remoteKeys = keys)
                database.trendingMoviesDao.insertAll(movies = data.movies)
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
        state: PagingState<Int, TrendingMovies>
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
        state: PagingState<Int, TrendingMovies>
    ): TrendingMoviesRemoteKey? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.movieId?.let { id ->
                database.trendingMoviesRemoteDao.remoteKeyId(
                    id
                )
            }
        }
    }

    private suspend fun getLastRemoteKey(state: PagingState<Int, TrendingMovies>): TrendingMoviesRemoteKey? {
        return state.pages
            .lastOrNull { it.data.isNotEmpty() }
            ?.data?.lastOrNull()
            ?.let { movie -> database.trendingMoviesRemoteDao.remoteKeyId(movie.movieId) }
    }

    private suspend fun getFirstRemoteKey(state: PagingState<Int, TrendingMovies>): TrendingMoviesRemoteKey? {
        return state.pages
            .firstOrNull { it.data.isNotEmpty() }
            ?.data?.firstOrNull()
            ?.let { movie -> database.trendingMoviesRemoteDao.remoteKeyId(movie.movieId) }
    }
}
