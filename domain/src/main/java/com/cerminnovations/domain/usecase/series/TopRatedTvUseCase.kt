package com.cerminnovations.domain.usecase.series

import androidx.paging.PagingData
import com.cerminnovations.domain.model.series.TvSeries
import com.cerminnovations.domain.repository.tv.TopRatedTvRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class TopRatedTvUseCase @Inject constructor(
    private val topRatedTvRepo: TopRatedTvRepo
) {
    operator fun invoke(): Flow<PagingData<TvSeries>> =
        topRatedTvRepo.getTopRatedSeries()
}
