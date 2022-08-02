package com.cerminnovations.domain.model.search

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
data class SearchResult(
    val id: Int?,
    val name: String?,
    val profilePath: String?,
    val backdropPath: String?,
    val posterPath: String?,
    val originalName: String?,
    val title: String?,
    val releaseDate: String?,
    val firstAirDate: String?,
    val voteAverage: Double?,
    val overview: String?,
    val mediaType: String?
)
