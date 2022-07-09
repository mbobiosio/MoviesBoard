package com.cerminnovations.moviesboard.data.remote.repository.tv

import com.cerminnovations.domain.model.series.TvSeriesInfo
import com.cerminnovations.domain.repository.tv.SeriesDetailRepository
import com.cerminnovations.moviesboard.data.mappers.TvDetailMapper
import com.cerminnovations.moviesboard.data.remote.api.ApiService
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class SeriesDetailRepoImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: TvDetailMapper
) : SeriesDetailRepository {

    override suspend fun getSeriesDetails(
        tvId: Long?,
        apiKey: String,
        appendToResponse: String
    ): TvSeriesInfo {
        val data = apiService.getSeriesByID(
            tvId,
            apiKey,
            appendToResponse
        )
        return mapper.map(data)
    }
}
