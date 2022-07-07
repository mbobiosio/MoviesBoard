package com.cerminnovations.moviesboard.data.remote.paging.tv

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.cerminnovations.core.constant.Constants
import com.cerminnovations.core.constant.Constants.DEFAULT_PAGE_INDEX
import com.cerminnovations.database.AppDatabase
import com.cerminnovations.database.entities.tv.toprated.TopRatedTv
import com.cerminnovations.database.entities.tv.toprated.TopRatedTvRemoteKey
import com.cerminnovations.moviesboard.data.mappers.mapTopRatedDataToEntity
import com.cerminnovations.moviesboard.data.remote.api.ApiService
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@ExperimentalPagingApi
class TopRatedTvMediator @Inject constructor(
    private val service: ApiService,
    private val database: AppDatabase
) : RemoteMediator<Int, TopRatedTv>() {

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, TopRatedTv>
    ): MediatorResult {
        val page = when (val pageKeyData = getKeyPageData(loadType, state)) {
            is MediatorResult.Success -> return pageKeyData
            else -> pageKeyData as Int
        }

        try {
            val response = service.getTopRatedSeries(
                apiKey = Constants.apiKey,
                page = page
            )

            val data = response.mapTopRatedDataToEntity()

            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    database.topRatedTvDao.deleteAll()
                    database.topRatedTvRemoteKeyDao.deleteAll()
                }

                val prevKey = if (page == DEFAULT_PAGE_INDEX) null else page - 1
                val nextKey = if (data.isEndOfListReached) null else page + 1

                val keys = data.results.map {
                    TopRatedTvRemoteKey(
                        it.tvId,
                        prevKey = prevKey,
                        nextKey = nextKey
                    )
                }

                database.topRatedTvRemoteKeyDao.insertKeys(remoteKeys = keys)
                database.topRatedTvDao.insertTopRatedSeries(series = data.results)
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
        state: PagingState<Int, TopRatedTv>
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
        state: PagingState<Int, TopRatedTv>
    ): TopRatedTvRemoteKey? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.tvId?.let { id ->
                database.topRatedTvRemoteKeyDao.remoteKeyId(id = id)
            }
        }
    }

    private suspend fun getLastRemoteKey(state: PagingState<Int, TopRatedTv>): TopRatedTvRemoteKey? {
        return state.pages
            .lastOrNull { it.data.isNotEmpty() }
            ?.data?.lastOrNull()
            ?.let { tv -> database.topRatedTvRemoteKeyDao.remoteKeyId(id = tv.tvId) }
    }

    private suspend fun getFirstRemoteKey(state: PagingState<Int, TopRatedTv>): TopRatedTvRemoteKey? {
        return state.pages
            .firstOrNull { it.data.isNotEmpty() }
            ?.data?.firstOrNull()
            ?.let { topRatedTv -> database.topRatedTvRemoteKeyDao.remoteKeyId(id = topRatedTv.tvId) }
    }
}
