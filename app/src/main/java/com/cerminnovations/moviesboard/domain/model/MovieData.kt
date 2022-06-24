package com.cerminnovations.moviesboard.domain.model

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
data class MovieData(
    val movieId: Long,
    val title: String,
    val originalTitle: String,
    val overview: String,
    val posterPath: String?,
    val backdropPath: String?,
    val releaseDate: String?,
    val originalLanguage: String,
    val popularity: Double,
    val voteCount: Int,
    val voteAverage: Double,
    val isAdult: Boolean
)
