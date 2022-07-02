package com.cerminnovations.moviesboard.data.mappers

import com.cerminnovations.domain.model.movies.MovieData
import com.cerminnovations.moviesboard.data.local.entities.movies.nowplaying.NowPlayingMovies
import com.cerminnovations.moviesboard.data.local.entities.movies.popular.PopularMovie
import com.cerminnovations.moviesboard.data.local.entities.movies.toprated.TopRatedMovie
import com.cerminnovations.moviesboard.data.local.entities.movies.trending.TrendingMovies
import com.cerminnovations.moviesboard.data.local.entities.movies.upcoming.UpcomingMovies

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
