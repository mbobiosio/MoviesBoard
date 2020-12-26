package com.mbobiosio.moviesboard.model

import com.mbobiosio.moviesboard.model.cast.Cast
import com.mbobiosio.moviesboard.model.crew.Crew
import com.squareup.moshi.Json

data class Credits(

    @Json(name = "id")
    val id: Int?,
    @Json(name = "cast")
    val casts: List<Cast>,
    @Json(name = "crew")
    val crews: List<Crew>

)
