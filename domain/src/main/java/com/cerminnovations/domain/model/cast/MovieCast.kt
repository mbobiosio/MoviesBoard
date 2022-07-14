package com.cerminnovations.domain.model.cast

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
data class MovieCast(
    val id: Int?,
    val title: String?,
    val overview: String?,
    val character: String?,
    val posterPath: String?,
    val backdropPath: String?,
    val voteAverage: Double?,
    val voteCount: Int?,
    val adult: Boolean?,
    val creditId: String?,
    val genreIds: List<Int>?,
    val originalLanguage: String?,
    val originalTitle: String?,
    val popularity: Double?,
    val releaseDate: String?,
    val video: Boolean?
)
