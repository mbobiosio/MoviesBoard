package com.cerminnovations.moviesboard.data.remote.repository.tv

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.map
import com.cerminnovations.core.util.defaultPageConfig
import com.cerminnovations.database.AppDatabase
import com.cerminnovations.domain.model.series.TvSeries
import com.cerminnovations.domain.repository.tv.TopRatedTvRepo
import com.cerminnovations.moviesboard.data.mappers.mapEntityToDomain
import com.cerminnovations.moviesboard.data.remote.paging.tv.TopRatedTvMediator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@ExperimentalPagingApi
class TopRatedTvRepoImpl @Inject constructor(
    private val database: AppDatabase,
    private val topRatedTvMediator: TopRatedTvMediator
) : TopRatedTvRepo {

    override fun getTopRatedSeries(): Flow<PagingData<TvSeries>> {
        val pagingSourceFactory = database.topRatedTvDao::getAll

        return Pager(
            config = defaultPageConfig(),
            remoteMediator = topRatedTvMediator,
            pagingSourceFactory = pagingSourceFactory
        ).flow.map {
            it.map { entity ->
                entity.mapEntityToDomain()
            }
        }
    }
}
