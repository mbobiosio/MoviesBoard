package com.cerminnovations.moviesboard.data.remote.model.crew

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CrewDto(

    @Json(name = "id")
    val id: Int,

    @Json(name = "credit_id")
    val creditId: String,

    @Json(name = "name")
    val name: String,

    @Json(name = "department")
    val department: String,

    @Json(name = "job")
    val job: String,

    @Json(name = "profile_path")
    val profilePath: String?,

    @Json(name = "gender")
    val gender: Int
)
