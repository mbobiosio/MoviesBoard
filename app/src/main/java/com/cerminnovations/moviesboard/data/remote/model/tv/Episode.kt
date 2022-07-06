package com.cerminnovations.moviesboard.data.remote.model.tv

import com.squareup.moshi.Json

data class Episode(

    @Json(name = "id")
    val id: Int,
    @Json(name = "air_date")
    val airDate: String,
    @Json(name = "episode_number")
    val episodeNumber: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "overview")
    val overview: String,
    @Json(name = "production_code")
    val productionCode: String?,
    @Json(name = "season_number")
    val seasonNumber: Int,
    @Json(name = "still_path")
    val stillPath: String?,
    @Json(name = "vote_average")
    val voteAverage: Double,
    @Json(name = "vote_count")
    val voteCount: Int

)
