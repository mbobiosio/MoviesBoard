package com.cerminnovations.domain.usecase.series

import androidx.paging.PagingData
import com.cerminnovations.domain.model.series.TvSeries
import com.cerminnovations.domain.repository.series.PopularTvRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class PopularTvUseCase @Inject constructor(
    private val popularTvRepo: PopularTvRepo
) {
    operator fun invoke(): Flow<PagingData<TvSeries>> =
        popularTvRepo.getPopularSeries()
}
