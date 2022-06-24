package com.cerminnovations.moviesboard.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@JsonClass(generateAdapter = true)
data class ErrorResponse(
    @Json(name = "status_code")
    val code: Int,
    @Json(name = "status_message")
    val message: String,
    @Json(name = "success")
    val status: Boolean
)
