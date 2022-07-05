package com.cerminnovations.moviesboard.data.remote.model.reviews

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@JsonClass(generateAdapter = true)
data class ReviewsDto(
    @Json(name = "page")
    val page: Int,

    @Json(name = "results")
    val results: List<ReviewDto>
)
