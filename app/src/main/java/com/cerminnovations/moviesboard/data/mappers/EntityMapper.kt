package com.cerminnovations.moviesboard.data.mappers

import com.cerminnovations.database.entities.movies.nowplaying.NowPlayingMovies
import com.cerminnovations.database.entities.movies.popular.PopularMovie
import com.cerminnovations.database.entities.movies.toprated.TopRatedMovie
import com.cerminnovations.database.entities.movies.trending.TrendingMovies
import com.cerminnovations.database.entities.movies.upcoming.UpcomingMovies
import com.cerminnovations.domain.model.movies.MovieData

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

fun UpcomingMovies.mapEntityToDomain(): MovieData =
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

fun TrendingMovies.mapEntityToDomain(): MovieData =
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

fun NowPlayingMovies.mapEntityToDomain(): MovieData =
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
