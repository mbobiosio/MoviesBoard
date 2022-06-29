package com.cerminnovations.moviesboard.model

import com.cerminnovations.moviesboard.model.cast.Cast
import com.cerminnovations.moviesboard.model.crew.Crew
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Credits(

    @Json(name = "id")
    val id: Int?,

    @Json(name = "cast")
    val casts: List<Cast>,

    @Json(name = "crew")
    val crews: List<Crew>
)
