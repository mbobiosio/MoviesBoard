package com.cerminnovations.moviesboard.data.mappers

import com.cerminnovations.core.error.ErrorMessage
import com.cerminnovations.domain.model.* // ktlint-disable no-wildcard-imports
import com.cerminnovations.domain.model.Collection
import com.cerminnovations.domain.model.cast.Cast
import com.cerminnovations.domain.model.crew.Crew
import com.cerminnovations.domain.model.graphics.ImageDetails
import com.cerminnovations.domain.model.graphics.Images
import com.cerminnovations.domain.model.movies.MovieDetail
import com.cerminnovations.domain.model.production.ProductionCompany
import com.cerminnovations.domain.model.production.ProductionCountry
import com.cerminnovations.domain.model.response.ListResponse
import com.cerminnovations.domain.model.video.Video
import com.cerminnovations.domain.model.video.VideoResponse
import com.cerminnovations.moviesboard.data.local.entities.movies.nowplaying.NowPlayingMovies
import com.cerminnovations.moviesboard.data.local.entities.movies.popular.PopularMovie
import com.cerminnovations.moviesboard.data.local.entities.movies.toprated.TopRatedMovie
import com.cerminnovations.moviesboard.data.local.entities.movies.trending.TrendingMovies
import com.cerminnovations.moviesboard.data.local.entities.movies.upcoming.UpcomingMovies
import com.cerminnovations.moviesboard.data.remote.model.CollectionDto
import com.cerminnovations.moviesboard.data.remote.model.CreditDto
import com.cerminnovations.moviesboard.data.remote.model.GenreDto
import com.cerminnovations.moviesboard.data.remote.model.SpokenLanguageDto
import com.cerminnovations.moviesboard.data.remote.model.cast.CastDto
import com.cerminnovations.moviesboard.data.remote.model.crew.CrewDto
import com.cerminnovations.moviesboard.data.remote.model.graphics.GraphicDetails
import com.cerminnovations.moviesboard.data.remote.model.graphics.GraphicDto
import com.cerminnovations.moviesboard.data.remote.model.movie.Movie
import com.cerminnovations.moviesboard.data.remote.model.movie.MovieDetails
import com.cerminnovations.moviesboard.data.remote.model.production.ProductionCompanyDto
import com.cerminnovations.moviesboard.data.remote.model.production.ProductionCountryDto
import com.cerminnovations.moviesboard.data.remote.model.response.BaseResponse
import com.cerminnovations.moviesboard.data.remote.model.video.VideoDto
import com.cerminnovations.moviesboard.data.remote.model.video.VideoResponseDto
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
interface Mapper<I, O> {
    fun map(input: I): O
}

class MovieDetailMapper @Inject constructor() : Mapper<MovieDetails, MovieDetail> {
    override fun map(input: MovieDetails): MovieDetail {
        return MovieDetail(
            id = input.id,
            imdbId = input.imdbId,
            title = input.title,
            originalTitle = input.originalTitle,
            originalLanguage = input.originalLanguage,
            overview = input.overview,
            posterPath = input.posterPath,
            backdropPath = input.backdropPath,
            releaseDate = input.releaseDate,
            runtime = input.runtime,
            voteCount = input.voteCount,
            voteAverage = input.voteAverage,
            status = input.status,
            tagline = input.tagline,
            budget = input.budget,
            popularity = input.popularity,
            revenue = input.revenue,
            adult = input.adult,
            homepage = input.homepage,
            video = input.video,
            genres = input.genreDto?.map {
                it.mapDataToDomain()
            },
            spokenLanguage = input.spokenLanguage?.map {
                it.mapDataToDomain()
            },
            collection = input.belongsToCollection?.mapDataToDomain(),
            productionCompany = productionCompanyMapper(input.productionCompanies),
            productionCountry = productionCountryMapper(input.productionCountries),
            images = input.images?.mapDataToDomain(),
            credits = input.credits?.mapDataToDomain(),
            videoResponse = input.videoResponse?.mapDataToDomain()
        )
    }
}

fun CreditDto.mapDataToDomain(): Credit =
    with(this) {
        Credit(
            id = id,
            casts = casts.map {
                it.mapDataToDomain()
            },
            crews = crews.map {
                it.mapDataToDomain()
            }
        )
    }

fun CrewDto.mapDataToDomain(): Crew =
    with(this) {
        Crew(
            id = id,
            creditId = creditId,
            name = name,
            department = department,
            job = job,
            profilePath = profilePath,
            gender = gender
        )
    }

fun CastDto.mapDataToDomain(): Cast =
    with(this) {
        Cast(
            id = id,
            name = name,
            creditId = creditId,
            character = character,
            order = order,
            profilePath = profilePath
        )
    }

fun VideoResponseDto.mapDataToDomain(): VideoResponse =
    with(this) {
        VideoResponse(
            results = results.map {
                it.mapDataToDomain()
            }
        )
    }

fun VideoDto.mapDataToDomain() =
    with(this) {
        Video(
            id = id,
            name = name,
            type = type,
            iso639 = iso639,
            iso3166 = iso3166,
            key = key,
            size = size,
            site = site
        )
    }

fun GraphicDto.mapDataToDomain(): Images =
    with(this) {
        Images(
            backdrops = backdrops?.map {
                it.mapDataToDomain()
            },
            posters = posters?.map {
                it.mapDataToDomain()
            }
        )
    }

fun GraphicDetails.mapDataToDomain() =
    with(this) {
        ImageDetails(
            aspectRatio = aspectRatio,
            filePath = filePath,
            width = width,
            height = height,
            iso631 = iso631,
            voteCount = voteCount,
            voteAverage = voteAverage
        )
    }

fun productionCountryMapper(productionCountry: List<ProductionCountryDto>?): List<ProductionCountry>? =
    productionCountry?.map {
        ProductionCountry(
            name = it.name,
            iso31661 = it.iso31661
        )
    }

fun productionCompanyMapper(productionCompany: List<ProductionCompanyDto>?): List<ProductionCompany>? =
    productionCompany?.map {
        ProductionCompany(
            id = it.id,
            logoPath = it.logoPath,
            name = it.name,
            originCountry = it.originCountry
        )
    }

fun CollectionDto.mapDataToDomain(): Collection =
    with(this) {
        Collection(
            id = id,
            name = name,
            posterPath = posterPath,
            backdropPath = backdropPath
        )
    }

fun GenreDto.mapDataToDomain(): Genre =
    with(this) {
        Genre(
            id = id,
            name = name
        )
    }

fun SpokenLanguageDto.mapDataToDomain(): SpokenLanguage =
    with(this) {
        SpokenLanguage(
            name = name,
            englishName = englishName,
            iso6391 = iso6391
        )
    }

fun BaseResponse<Movie>.mapDataToPopularMoviesEntity(): ListResponse<PopularMovie> =
    with(this) {
        ListResponse(
            page = page,
            totalResults = totalResults,
            totalPages = totalPages,
            results = results.map {
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

fun BaseResponse<Movie>.mapDataToTopRatedMovieEntity(): ListResponse<TopRatedMovie> =
    with(this) {
        ListResponse(
            page = page,
            totalResults = totalResults,
            totalPages = totalPages,
            results = results.map {
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

fun BaseResponse<Movie>.mapDataToUpcomingMovieEntity(): ListResponse<UpcomingMovies> =
    with(this) {
        ListResponse(
            page = page,
            totalResults = totalResults,
            totalPages = totalPages,
            results = results.map {
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

fun BaseResponse<Movie>.mapDataToNowPlayingMovieEntity(): ListResponse<NowPlayingMovies> =
    with(this) {
        ListResponse(
            page = page,
            totalResults = totalResults,
            totalPages = totalPages,
            results = results.map {
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

fun BaseResponse<Movie>.mapDataToTrendingMovieEntity(): ListResponse<TrendingMovies> =
    with(this) {
        ListResponse(
            page = page,
            totalResults = totalResults,
            totalPages = totalPages,
            results = results.map {
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

fun ErrorMessage.mapDataToDomain(): ErrorResponse =
    with(this) {
        ErrorResponse(
            errorMessage = errorMessage
        )
    }
