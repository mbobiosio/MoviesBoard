package com.mbobiosio.moviesboard.model.artists

import com.mbobiosio.moviesboard.model.response.Response
import com.squareup.moshi.Json

data class Artist(

    @Json(name = "id")
    val id: Int,
    @Json(name = "profile_path")
    val profilePath: String?,
    @Json(name = "name")
    val name: String,
    @Json(name = "popularity")
    val popularity: Double = 0.0,
    @Json(name = "known_for_department")
    val knowForDepartment: String?

) : Response
