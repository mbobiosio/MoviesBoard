package com.cerminnovations.core.error

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@JsonClass(generateAdapter = true)
data class ErrorResponse(
    @Json(name = "status_message")
    val errorMessage: String?
)
