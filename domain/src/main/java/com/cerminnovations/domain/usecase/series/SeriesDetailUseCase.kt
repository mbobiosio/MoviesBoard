package com.cerminnovations.domain.usecase.series

import com.cerminnovations.core.util.Resource
import com.cerminnovations.core.util.network.safeApiCall
import com.cerminnovations.domain.model.series.TvSeriesInfo
import com.cerminnovations.domain.repository.tv.SeriesDetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class SeriesDetailUseCase @Inject constructor(
    private val seriesDetailRepository: SeriesDetailRepository
) {
    operator fun invoke(
        tvId: Long?,
        apiKey: String,
        appendToResponse: String
    ): Flow<Resource<TvSeriesInfo>> = flow {
        emit(
            safeApiCall {
                seriesDetailRepository.getSeriesDetails(
                    tvId, apiKey, appendToResponse
                )
            }
        )
    }.flowOn(Dispatchers.IO)
}
