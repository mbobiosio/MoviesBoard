package com.cerminnovations.moviesboard.data.mappers

import com.cerminnovations.core.base.ListMapper
import com.cerminnovations.database.entities.favorite.MovieFavorite
import com.cerminnovations.domain.model.Favorite
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
fun Favorite.mapEntityToDomain(): MovieFavorite =
    with(this) {
        MovieFavorite(
            id = id,
            imdbId = imdbId,
            title = title,
            originalTitle = originalTitle,
            originalLanguage = originalLanguage,
            overview = overview,
            posterPath = posterPath,
            backdropPath = backdropPath,
            releaseDate = releaseDate,
            runtime = runtime,
            voteCount = voteCount,
            voteAverage = voteAverage,
            status = status,
            tagline = tagline,
            budget = budget,
            popularity = popularity,
            revenue = revenue,
            adult = adult,
            video = video,
            homepage = homepage
        )
    }

class FavoriteMovieMapper @Inject constructor() : ListMapper<MovieFavorite, Favorite> {
    override fun map(input: List<MovieFavorite>): List<Favorite> {
        return input.map { favorite ->
            Favorite(
                id = favorite.id,
                imdbId = favorite.imdbId,
                title = favorite.title,
                originalTitle = favorite.originalTitle,
                originalLanguage = favorite.originalLanguage,
                overview = favorite.overview,
                posterPath = favorite.posterPath,
                backdropPath = favorite.backdropPath,
                releaseDate = favorite.releaseDate,
                runtime = favorite.runtime,
                voteCount = favorite.voteCount,
                voteAverage = favorite.voteAverage,
                status = favorite.status,
                tagline = favorite.tagline,
                budget = favorite.budget,
                popularity = favorite.popularity,
                revenue = favorite.revenue,
                adult = favorite.adult,
                video = favorite.video,
                homepage = favorite.homepage
            )
        }
    }
}