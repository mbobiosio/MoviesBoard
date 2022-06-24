package com.cerminnovations.moviesboard.data.mappers

import com.cerminnovations.moviesboard.data.local.entities.popular.PopularMovie
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
