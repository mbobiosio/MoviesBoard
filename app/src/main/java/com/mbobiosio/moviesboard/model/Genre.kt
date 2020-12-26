package com.mbobiosio.moviesboard.model

import com.squareup.moshi.Json

data class Genre(
    @Json(name = "id") val id: Int,
    @Json(name = "id") val name: String
)
