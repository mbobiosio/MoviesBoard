package com.cerminnovations.moviesboard.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@JsonClass(generateAdapter = true)
data class GenreDto(
    @Json(name = "id")
    val id: Int,

    @Json(name = "name")
    val name: String
)
