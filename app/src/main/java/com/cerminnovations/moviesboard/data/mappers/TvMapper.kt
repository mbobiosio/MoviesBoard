package com.cerminnovations.moviesboard.data.mappers

import com.cerminnovations.database.entities.tv.popular.PopularTv
import com.cerminnovations.domain.model.response.ListResponse
import com.cerminnovations.domain.model.series.TvSeries
import com.cerminnovations.moviesboard.data.remote.model.response.BaseResponse
import com.cerminnovations.moviesboard.data.remote.model.tv.Series

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
fun BaseResponse<Series>.mapDataToEntity(): ListResponse<PopularTv> =
    with(this) {
        ListResponse(
            page = page,
            totalResults = totalResults,
            totalPages = totalPages,
            results = results.map {
                PopularTv(
                    it.id,
                    it.name,
                    it.posterPath,
                    it.popularity,
                    it.backdropPath,
                    it.voteAverage,
                    it.overview,
                    it.firstAirDate,
                    it.originCountry,
                    it.genreIds,
                    it.originalLanguage,
                    it.voteCount,
                    it.originalName
                )
            }
        )
    }

fun PopularTv.mapEntityToDomain(): TvSeries =
    with(this) {
        TvSeries(
            tvId = tvId,
            name = name,
            posterPath = posterPath,
            popularity = popularity,
            backdropPath = backdropPath,
            voteAverage = voteAverage,
            overview = overview,
            firstAirDate = firstAirDate,
            originCountry = originCountry,
            genreIds = genreIds,
            originalLanguage = originalLanguage,
            voteCount = voteCount,
            originalName = originalName
        )
    }
