package com.cerminnovations.moviesboard.data.mappers

import com.cerminnovations.moviesboard.data.local.entities.movies.nowplaying.NowPlayingMovies
import com.cerminnovations.moviesboard.data.local.entities.movies.popular.PopularMovie
import com.cerminnovations.moviesboard.data.local.entities.movies.toprated.TopRatedMovie
import com.cerminnovations.moviesboard.data.local.entities.movies.trending.TrendingMovies
import com.cerminnovations.moviesboard.data.local.entities.movies.upcoming.UpcomingMovies
import com.cerminnovations.moviesboard.data.remote.model.movie.MovieResponse
import com.cerminnovations.moviesboard.domain.model.Movies

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
fun MovieResponse.mapDataToPopularMoviesEntity(): Movies<PopularMovie> =
    with(this) {
        Movies(
            total = totalResults,
            page = page,
            movies = results.map {
                PopularMovie(
                    it.id,
                    it.title,
                    it.originalTitle,
                    it.overview,
                    it.posterPath,
                    it.backdropPath,
                    it.releaseDate,
                    it.originalLanguage,
                    it.popularity,
                    it.voteCount,
                    it.voteAverage,
                    it.isAdult
                )
            }
        )
    }

fun MovieResponse.mapDataToTopRatedMovieEntity(): Movies<TopRatedMovie> =
    with(this) {
        Movies(
            total = totalResults,
            page = page,
            movies = results.map {
                TopRatedMovie(
                    it.id,
                    it.title,
                    it.originalTitle,
                    it.overview,
                    it.posterPath,
                    it.backdropPath,
                    it.releaseDate,
                    it.originalLanguage,
                    it.popularity,
                    it.voteCount,
                    it.voteAverage,
                    it.isAdult
                )
            }
        )
    }

fun MovieResponse.mapDataToUpcomingMovieEntity(): Movies<UpcomingMovies> =
    with(this) {
        Movies(
            total = totalResults,
            page = page,
            movies = results.map {
                UpcomingMovies(
                    it.id,
                    it.title,
                    it.originalTitle,
                    it.overview,
                    it.posterPath,
                    it.backdropPath,
                    it.releaseDate,
                    it.originalLanguage,
                    it.popularity,
                    it.voteCount,
                    it.voteAverage,
                    it.isAdult
                )
            }
        )
    }

fun MovieResponse.mapDataToNowPlayingMovieEntity(): Movies<NowPlayingMovies> =
    with(this) {
        Movies(
            total = totalResults,
            page = page,
            movies = results.map {
                NowPlayingMovies(
                    it.id,
                    it.title,
                    it.originalTitle,
                    it.overview,
                    it.posterPath,
                    it.backdropPath,
                    it.releaseDate,
                    it.originalLanguage,
                    it.popularity,
                    it.voteCount,
                    it.voteAverage,
                    it.isAdult
                )
            }
        )
    }

fun MovieResponse.mapDataToTrendingMovieEntity(): Movies<TrendingMovies> =
    with(this) {
        Movies(
            total = totalResults,
            page = page,
            movies = results.map {
                TrendingMovies(
                    it.id,
                    it.title,
                    it.originalTitle,
                    it.overview,
                    it.posterPath,
                    it.backdropPath,
                    it.releaseDate,
                    it.originalLanguage,
                    it.popularity,
                    it.voteCount,
                    it.voteAverage,
                    it.isAdult
                )
            }
        )
    }
