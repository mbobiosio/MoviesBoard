package com.cerminnovations.moviesboard.data.remote.repository.tv

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.map
import com.cerminnovations.core.util.defaultPageConfig
import com.cerminnovations.domain.model.series.TvSeries
import com.cerminnovations.domain.repository.series.PopularTvRepo
import com.cerminnovations.moviesboard.data.local.AppDatabase
import com.cerminnovations.moviesboard.data.mappers.mapEntityToDomain
import com.cerminnovations.moviesboard.data.remote.paging.tv.PopularTvMediator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@ExperimentalPagingApi
class PopularTvRepoImpl @Inject constructor(
    private val database: AppDatabase,
    private val popularTvMediator: PopularTvMediator
) : PopularTvRepo {

    override fun getPopularSeries(): Flow<PagingData<TvSeries>> {
        val pagingSourceFactory = database.popularTvDao::getAll

        return Pager(
            config = defaultPageConfig(),
            remoteMediator = popularTvMediator,
            pagingSourceFactory = pagingSourceFactory
        ).flow.map {
            it.map { entity ->
                entity.mapEntityToDomain()
            }
        }
    }
}
