package com.cerminnovations.moviesboard.data.local.entities.movies.popular

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Entity(tableName = "popular_movies")
data class PopularMovie(
    val movieId: Long,
    @PrimaryKey
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
