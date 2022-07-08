package com.cerminnovations.moviesboard.data.remote.paging.tv

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.cerminnovations.core.constant.Constants
import com.cerminnovations.database.AppDatabase
import com.cerminnovations.database.entities.tv.trendingweek.TrendingWeek
import com.cerminnovations.database.entities.tv.trendingweek.TrendingWeekRemoteKey
import com.cerminnovations.moviesboard.data.mappers.mapTrendingWeekDataToEntity
import com.cerminnovations.moviesboard.data.remote.api.ApiService
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@ExperimentalPagingApi
class TrendingWeekMediator @Inject constructor(
    private val service: ApiService,
    private val database: AppDatabase
) : RemoteMediator<Int, TrendingWeek>() {

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, TrendingWeek>
    ): MediatorResult {
        val page = when (val pageKeyData = getKeyPageData(loadType, state)) {
            is MediatorResult.Success -> return pageKeyData
            else -> pageKeyData as Int
        }

        try {
            val response = service.getTrendingSeries(
                mediaType = "tv",
                timeWindow = "week",
                apiKey = Constants.apiKey,
                page = page
            )

            val data = response.mapTrendingWeekDataToEntity()

            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    database.trendingWeekDao.deleteAll()
                    database.trendingWeekRemoteKeyDao.deleteAll()
                }

                val prevKey = if (page == Constants.DEFAULT_PAGE_INDEX) null else page - 1
                val nextKey = if (data.isEndOfListReached) null else page + 1

                val keys = data.results.map {
                    TrendingWeekRemoteKey(
                        it.tvId,
                        prevKey = prevKey,
                        nextKey = nextKey
                    )
                }

                database.trendingWeekRemoteKeyDao.insertKeys(remoteKeys = keys)
                database.trendingWeekDao.insertTrendingWeek(data.results)
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
        state: PagingState<Int, TrendingWeek>
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
        state: PagingState<Int, TrendingWeek>
    ): TrendingWeekRemoteKey? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.tvId?.let { id ->
                database.trendingWeekRemoteKeyDao.remoteKeyId(
                    id = id
                )
            }
        }
    }

    private suspend fun getLastRemoteKey(state: PagingState<Int, TrendingWeek>): TrendingWeekRemoteKey? {
        return state.pages
            .lastOrNull { it.data.isNotEmpty() }
            ?.data?.lastOrNull()
            ?.let { tv -> database.trendingWeekRemoteKeyDao.remoteKeyId(id = tv.tvId) }
    }

    private suspend fun getFirstRemoteKey(state: PagingState<Int, TrendingWeek>): TrendingWeekRemoteKey? {
        return state.pages
            .firstOrNull { it.data.isNotEmpty() }
            ?.data?.firstOrNull()
            ?.let { popularTv -> database.trendingWeekRemoteKeyDao.remoteKeyId(id = popularTv.tvId) }
    }
}
