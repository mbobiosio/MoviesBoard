package com.cerminnovations.domain.model.cast

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
data class TvCast(
    val id: Int,
    val name: String,
    val backdropPath: String?,
    val posterPath: String?,
    val character: String,
    val overview: String,
    val popularity: Double,
    val voteAverage: Double,
    val voteCount: Int,
    val creditId: String,
    val episodeCount: Int?,
    val firstAirDate: String?,
    val genreIds: List<Int>,
    val originCountry: List<String>,
    val originalLanguage: String,
    val originalName: String
)
