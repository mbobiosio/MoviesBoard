package com.cerminnovations.moviesboard.data.remote.repository.tv

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.map
import com.cerminnovations.core.util.defaultPageConfig
import com.cerminnovations.database.AppDatabase
import com.cerminnovations.domain.model.series.TvSeries
import com.cerminnovations.domain.repository.tv.TrendingTodayTvRepo
import com.cerminnovations.moviesboard.data.mappers.mapEntityToDomain
import com.cerminnovations.moviesboard.data.remote.paging.tv.TrendingTodayMediator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@ExperimentalPagingApi
class TrendingTodayTvRepoImpl @Inject constructor(
    private val database: AppDatabase,
    private val trendingTodayMediator: TrendingTodayMediator
) : TrendingTodayTvRepo {

    override fun getTrendingTodaySeries(): Flow<PagingData<TvSeries>> {
        val pagingSourceFactory = database.trendingTodayDao::getAll

        return Pager(
            config = defaultPageConfig(),
            remoteMediator = trendingTodayMediator,
            pagingSourceFactory = pagingSourceFactory
        ).flow.map {
            it.map { entity ->
                entity.mapEntityToDomain()
            }
        }
    }
}
