package com.cerminnovations.domain.usecase.series

import androidx.paging.PagingData
import com.cerminnovations.domain.model.series.TvSeries
import com.cerminnovations.domain.repository.tv.TrendingTodayTvRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class TrendingTodayTvUseCase @Inject constructor(
    private val trendingTodayTvRepo: TrendingTodayTvRepo
) {
    operator fun invoke(): Flow<PagingData<TvSeries>> =
        trendingTodayTvRepo.getTrendingTodaySeries()
}
