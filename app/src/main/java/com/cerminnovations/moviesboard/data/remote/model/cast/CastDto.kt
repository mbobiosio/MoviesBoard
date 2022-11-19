package com.cerminnovations.moviesboard.data.remote.model.cast

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CastDto(

    @Json(name = "id")
    val id: Long,

    @Json(name = "name")
    val name: String,

    @Json(name = "credit_id")
    val creditId: String,

    @Json(name = "character")
    val character: String?,

    @Json(name = "order")
    val order: Int?,

    @Json(name = "profile_path")
    val profilePath: String?
)
