package com.mbobiosio.moviesboard.model.crew

import com.squareup.moshi.Json

data class TVCrew(

    @Json(name = "backdrop_path")
    val backdropPath: String?,

    @Json(name = "credit_id")
    val creditId: String,

    @Json(name = "department")
    val department: String,

    @Json(name = "episode_count")
    val episodeCount: Int,

    @Json(name = "first_air_date")
    val firstAirDate: String,

    @Json(name = "genre_ids")
    val genreIds: List<Int>,

    @Json(name = "id")
    val id: Int,

    @Json(name = "job")
    val job: String,

    @Json(name = "name")
    val name: String,

    @Json(name = "origin_country")
    val originCountry: List<String>,

    @Json(name = "original_language")
    val originalLanguage: String,

    @Json(name = "original_name")
    val originalName: String,

    @Json(name = "overview")
    val overview: String,

    @Json(name = "popularity")
    val popularity: Double,

    @Json(name = "poster_path")
    val posterPath: String?,

    @Json(name = "vote_average")
    val voteAverage: Double,

    @Json(name = "vote_count")
    val voteCount: Int
)
