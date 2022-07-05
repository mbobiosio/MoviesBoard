package com.cerminnovations.moviesboard.data.remote.model.reviews

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@JsonClass(generateAdapter = true)
data class AuthorDetailsDto(
    @Json(name = "name")
    val authorName: String,

    @Json(name = "username")
    val username: String,

    @Json(name = "avatar_path")
    val avatar: String,

    @Json(name = "rating")
    val rating: Double
)
