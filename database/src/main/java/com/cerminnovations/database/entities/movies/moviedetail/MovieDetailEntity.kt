package com.cerminnovations.database.entities.movies.moviedetail

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Entity(tableName = "movie_detail")
data class MovieDetailEntity(
    val imdbId: String?,
    @PrimaryKey
    val id: Int,
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
