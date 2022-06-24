package com.cerminnovations.moviesboard.data.mappers

import com.cerminnovations.moviesboard.data.local.entities.movies.popular.PopularMovie
import com.cerminnovations.moviesboard.data.local.entities.movies.toprated.TopRatedMovie
import com.cerminnovations.moviesboard.domain.model.MovieData

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
fun PopularMovie.mapEntityToDomain(): MovieData =
    with(this) {
        MovieData(
            movieId = movieId,
            title = title,
            originalTitle = originalTitle,
            overview = overview,
            posterPath = posterPath,
            backdropPath = backdropPath,
            releaseDate = releaseDate,
            originalLanguage = originalLanguage,
            popularity = popularity,
            voteCount = voteCount,
            voteAverage = voteAverage,
            isAdult = isAdult
        )
    }

fun TopRatedMovie.mapEntityToDomain(): MovieData =
    with(this) {
        MovieData(
            movieId = movieId,
            title = title,
            originalTitle = originalTitle,
            overview = overview,
            posterPath = posterPath,
            backdropPath = backdropPath,
            releaseDate = releaseDate,
            originalLanguage = originalLanguage,
            popularity = popularity,
            voteCount = voteCount,
            voteAverage = voteAverage,
            isAdult = isAdult
        )
    }
