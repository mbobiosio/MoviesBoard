package com.cerminnovations.domain.usecase.series

import androidx.paging.PagingData
import com.cerminnovations.domain.model.series.TvSeries
import com.cerminnovations.domain.repository.tv.ShowingTodayTvRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class ShowingTodayTvUseCase @Inject constructor(
    private val showingTodayTvRepo: ShowingTodayTvRepo
) {
    operator fun invoke(): Flow<PagingData<TvSeries>> =
        showingTodayTvRepo.getShowingTodaySeries()
}
