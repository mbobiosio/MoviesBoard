package com.cerminnovations.moviesboard.model.shows

import com.squareup.moshi.Json

data class SeriesSeasonDetails(

    @Json(name = "_id")
    val primaryId: String,

    @Json(name = "air_date")
    val airDate: String,

    @Json(name = "episodes")
    val episodes: List<Episode>,

    @Json(name = "name")
    val name: String,

    @Json(name = "overview")
    val overview: String,

    @Json(name = "id")
    val id: Int,

    @Json(name = "poster_path")
    val posterPath: String?,

    @Json(name = "season_number")
    val seasonNumber: Int

)