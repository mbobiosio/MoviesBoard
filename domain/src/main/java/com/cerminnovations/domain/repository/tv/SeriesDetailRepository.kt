package com.cerminnovations.domain.repository.tv

import com.cerminnovations.domain.model.series.TvSeriesInfo

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
interface SeriesDetailRepository {

    suspend fun getSeriesDetails(
        tvId: Long?,
        apiKey: String,
        appendToResponse: String
    ): TvSeriesInfo
}
