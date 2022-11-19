package com.cerminnovations.domain.model

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
data class Favorite(
    val id: Int,
    val imdbId: String?,
    val title: String,
    val originalTitle: String,
    val originalLanguage: String,
    val overview: String?,
    val posterPath: String?,
    val backdropPath: String?,
    val releaseDate: String,
    val runtime: Int?,
    val voteCount: Int,
    val voteAverage: Double,
    val status: String,
    val tagline: String?,
    val budget: Int,
    val popularity: Double,
    val revenue: Long,
    val adult: Boolean,
    val video: Boolean,
    val homepage: String?
)
