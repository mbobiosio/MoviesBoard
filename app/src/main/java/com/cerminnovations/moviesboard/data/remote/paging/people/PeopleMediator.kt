package com.cerminnovations.moviesboard.data.remote.paging.people

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.cerminnovations.core.constant.Constants
import com.cerminnovations.database.AppDatabase
import com.cerminnovations.database.entities.people.PeopleEntity
import com.cerminnovations.database.entities.people.PeopleRemoteKey
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
class PeopleMediator @Inject constructor(
    private val service: ApiService,
    private val database: AppDatabase
) : RemoteMediator<Int, PeopleEntity>() {

    override suspend fun initialize(): InitializeAction {
        return super.initialize()
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PeopleEntity>
    ): MediatorResult {
        val page = when (val pageKeyData = getKeyPageData(loadType, state)) {
            is MediatorResult.Success -> return pageKeyData
            else -> pageKeyData as Int
        }

        try {
            val response = service.getPopularArtists(
                apiKey = Constants.apiKey,
                page = page
            )

            val data = response.mapDataToEntity()

            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    database.peopleRemoteKeyDao.deleteAll()
                    database.peopleDao.deleteAll()
                }

                val prevKey = if (page == Constants.DEFAULT_PAGE_INDEX) null else page - 1
                val nextKey = if (data.isEndOfListReached) null else page + 1
                val keys = data.results.map {
                    PeopleRemoteKey(
                        it.id,
                        prevKey = prevKey,
                        nextKey = nextKey
                    )
                }

                database.peopleRemoteKeyDao.insertAll(remoteKeys = keys)
                database.peopleDao.insertAll(people = data.results)
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
        state: PagingState<Int, PeopleEntity>
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
        state: PagingState<Int, PeopleEntity>
    ): PeopleRemoteKey? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                database.peopleRemoteKeyDao.remoteKeyId(
                    id
                )
            }
        }
    }

    private suspend fun getLastRemoteKey(state: PagingState<Int, PeopleEntity>): PeopleRemoteKey? {
        return state.pages
            .lastOrNull { it.data.isNotEmpty() }
            ?.data?.lastOrNull()
            ?.let { person -> database.peopleRemoteKeyDao.remoteKeyId(person.id) }
    }

    private suspend fun getFirstRemoteKey(state: PagingState<Int, PeopleEntity>): PeopleRemoteKey? {
        return state.pages
            .firstOrNull { it.data.isNotEmpty() }
            ?.data?.firstOrNull()
            ?.let { person -> database.peopleRemoteKeyDao.remoteKeyId(person.id) }
    }
}
