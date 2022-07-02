package com.cerminnovations.moviesboard.data.remote.model

import com.cerminnovations.moviesboard.data.remote.model.cast.CastDto
import com.cerminnovations.moviesboard.data.remote.model.crew.Crew
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Credits(

    @Json(name = "id")
    val id: Int?,

    @Json(name = "cast")
    val casts: List<CastDto>,

    @Json(name = "crew")
    val crews: List<Crew>
)
