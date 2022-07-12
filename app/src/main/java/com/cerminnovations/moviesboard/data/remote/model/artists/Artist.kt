package com.cerminnovations.moviesboard.data.remote.model.artists

import com.squareup.moshi.Json

data class Artist(

    @Json(name = "id")
    val id: Long,
    @Json(name = "profile_path")
    val profilePath: String?,
    @Json(name = "name")
    val name: String,
    @Json(name = "popularity")
    val popularity: Double?,
    @Json(name = "known_for_department")
    val knownForDepartment: String?
)
