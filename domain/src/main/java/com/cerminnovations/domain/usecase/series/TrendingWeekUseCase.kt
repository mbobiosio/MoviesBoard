package com.cerminnovations.domain.usecase.series

import androidx.paging.PagingData
import com.cerminnovations.domain.model.series.TvSeries
import com.cerminnovations.domain.repository.tv.TrendingWeekTvRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class TrendingWeekUseCase @Inject constructor(
    private val trendingWeekTvRepo: TrendingWeekTvRepo
) {
    operator fun invoke(): Flow<PagingData<TvSeries>> =
        trendingWeekTvRepo.getTrendingWeekSeries()
}
