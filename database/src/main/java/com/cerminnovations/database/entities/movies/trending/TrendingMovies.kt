package com.cerminnovations.database.entities.movies.trending

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Entity(tableName = "trending_movies")
data class TrendingMovies(
    val movieId: Long,
    @PrimaryKey
    val title: String,
    val originalTitle: String,
    val overview: String,
    val posterPath: String?,
    val backdropPath: String?,
    val releaseDate: String?,
    val originalLanguage: String,
    val popularity: Float,
    val voteCount: Int,
    val voteAverage: Double,
    val isAdult: Boolean
)
