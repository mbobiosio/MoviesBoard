package com.cerminnovations.moviesboard.data.remote.model.cast

import com.squareup.moshi.Json

data class SeriesCastDto(

    @Json(name = "id")
    val id: Int,

    @Json(name = "name")
    val name: String,

    @Json(name = "backdrop_path")
    val backdropPath: String?,

    @Json(name = "poster_path")
    val posterPath: String?,

    @Json(name = "character")
    val character: String,

    @Json(name = "overview")
    val overview: String,

    @Json(name = "popularity")
    val popularity: Double,

    @Json(name = "vote_average")
    val voteAverage: Double,

    @Json(name = "vote_count")
    val voteCount: Int,

    @Json(name = "credit_id")
    val creditId: String,

    @Json(name = "episode_count")
    val episodeCount: Int?,

    @Json(name = "first_air_date")
    val firstAirDate: String?,

    @Json(name = "genre_ids")
    val genreIds: List<Int>,

    @Json(name = "origin_country")
    val originCountry: List<String>,

    @Json(name = "original_language")
    val originalLanguage: String,

    @Json(name = "original_name")
    val originalName: String

)
