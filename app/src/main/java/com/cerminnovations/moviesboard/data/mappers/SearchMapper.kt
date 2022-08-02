package com.cerminnovations.moviesboard.data.mappers

import com.cerminnovations.domain.model.search.SearchResult
import com.cerminnovations.moviesboard.data.remote.model.search.SearchResultDto

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
fun SearchResultDto.mapToDomain() : SearchResult =
    with(this) {
        SearchResult(
            id = id,
            name = name,
            backdropPath = backdropPath,
            profilePath = profilePath,
            originalName = originalName,
            title = title,
            firstAirDate = firstAirDate,
            voteAverage = voteAverage,
            posterPath = posterPath,
            releaseDate = releaseDate,
            overview = overview,
            mediaType = mediaType
        )
    }