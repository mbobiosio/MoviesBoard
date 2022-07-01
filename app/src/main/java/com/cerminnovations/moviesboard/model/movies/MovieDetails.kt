package com.cerminnovations.moviesboard.model.movies

import com.cerminnovations.moviesboard.model.CollectionDto
import com.cerminnovations.moviesboard.model.Credits
import com.cerminnovations.moviesboard.model.GenreDto
import com.cerminnovations.moviesboard.model.SpokenLanguageDto
import com.cerminnovations.moviesboard.model.graphics.GraphicDto
import com.cerminnovations.moviesboard.model.production.ProductionCompanyDto
import com.cerminnovations.moviesboard.model.production.ProductionCountryDto
import com.cerminnovations.moviesboard.model.video.VideoResponseDto
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieDetails(

    @Json(name = "id")
    val id: Long,

    @Json(name = "imdb_id")
    val imdbId: String?,

    @Json(name = "title")
    val title: String,

    @Json(name = "original_title")
    val originalTitle: String,

    @Json(name = "original_language")
    val originalLanguage: String,

    @Json(name = "overview")
    val overview: String?,

    @Json(name = "poster_path")
    val posterPath: String?,

    @Json(name = "backdrop_path")
    val backdropPath: String?,

    @Json(name = "release_date")
    val releaseDate: String,

    @Json(name = "runtime")
    val runtime: Int?,

    @Json(name = "vote_count")
    val voteCount: Int,

    @Json(name = "vote_average")
    val voteAverage: Double,

    @Json(name = "status")
    val status: String,

    @Json(name = "tagline")
    val tagline: String?,

    @Json(name = "budget")
    val budget: Int,

    @Json(name = "popularity")
    val popularity: Double,

    @Json(name = "revenue")
    val revenue: Long,

    @Json(name = "adult")
    val adult: Boolean,

    @Json(name = "homepage")
    val homepage: String?,

    @Json(name = "video")
    val video: Boolean,

    @Json(name = "genres")
    val genreDto: List<GenreDto>?,

    @Json(name = "spoken_languages")
    val spokenLanguage: List<SpokenLanguageDto>?,

    @Json(name = "belongs_to_collection")
    val belongsToCollection: CollectionDto?,

    @Json(name = "production_companies")
    val productionCompanies: List<ProductionCompanyDto>?,

    @Json(name = "production_countries")
    val productionCountries: List<ProductionCountryDto>?,

    // AppendToResponse
    @Json(name = "images")
    val images: GraphicDto?,

    @Json(name = "credits")
    val credits: Credits?,

    @Json(name = "videos")
    val videoResponse: VideoResponseDto?
)
