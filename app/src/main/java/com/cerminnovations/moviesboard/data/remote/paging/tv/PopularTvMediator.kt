package com.cerminnovations.moviesboard.data.remote.paging.tv

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.cerminnovations.core.constant.Constants
import com.cerminnovations.core.constant.Constants.DEFAULT_PAGE_INDEX
import com.cerminnovations.moviesboard.data.local.AppDatabase
import com.cerminnovations.moviesboard.data.local.entities.tv.popular.PopularTv
import com.cerminnovations.moviesboard.data.local.entities.tv.popular.PopularTvRemoteKey
import com.cerminnovations.moviesboard.data.mappers.mapDataToEntity
import com.cerminnovations.moviesboard.data.remote.api.ApiService
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@ExperimentalPagingApi
class PopularTvMediator @Inject constructor(
    private val service: ApiService,
    private val database: AppDatabase
) : RemoteMediator<Int, PopularTv>() {

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PopularTv>
    ): MediatorResult {
        val page = when (val pageKeyData = getKeyPageData(loadType, state)) {
            is MediatorResult.Success -> return pageKeyData
            else -> pageKeyData as Int
        }

        try {
            val response = service.getPopularSeries(
                apiKey = Constants.apiKey,
                page = page
            )

            val data = response.mapDataToEntity()

            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    database.popularTvDao.deleteAll()
                    database.popularTvRemoteKeyDao.deleteAll()
                }

                val prevKey = if (page == DEFAULT_PAGE_INDEX) null else page - 1
                val nextKey = if (data.isEndOfListReached) null else page + 1

                val keys = data.results.map {
                    PopularTvRemoteKey(
                        it.tvId,
                        prevKey = prevKey,
                        nextKey = nextKey
                    )
                }

                database.popularTvRemoteKeyDao.insertKeys(remoteKeys = keys)
                database.popularTvDao.insertTvSeries(data.results)
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
        state: PagingState<Int, PopularTv>
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
        state: PagingState<Int, PopularTv>
    ): PopularTvRemoteKey? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.tvId?.let { id ->
                database.popularTvRemoteKeyDao.remoteKeyId(
                    id = id
                )
            }
        }
    }

    private suspend fun getLastRemoteKey(state: PagingState<Int, PopularTv>): PopularTvRemoteKey? {
        return state.pages
            .lastOrNull { it.data.isNotEmpty() }
            ?.data?.lastOrNull()
            ?.let { tv -> database.popularTvRemoteKeyDao.remoteKeyId(id = tv.tvId) }
    }

    private suspend fun getFirstRemoteKey(state: PagingState<Int, PopularTv>): PopularTvRemoteKey? {
        return state.pages
            .firstOrNull { it.data.isNotEmpty() }
            ?.data?.firstOrNull()
            ?.let { popularTv -> database.popularTvRemoteKeyDao.remoteKeyId(id = popularTv.tvId) }
    }
}
