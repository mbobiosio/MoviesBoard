package com.cerminnovations.domain.usecase.series

import androidx.paging.PagingData
import com.cerminnovations.domain.model.series.TvSeries
import com.cerminnovations.domain.repository.tv.NowShowingTvRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class NowShowingTvUseCase @Inject constructor(
    private val nowShowingTvRepo: NowShowingTvRepo
) {
    operator fun invoke(): Flow<PagingData<TvSeries>> =
        nowShowingTvRepo.getNowShowingSeries()
}
