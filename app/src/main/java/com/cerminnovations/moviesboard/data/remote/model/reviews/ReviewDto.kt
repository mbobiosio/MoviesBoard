package com.cerminnovations.moviesboard.data.remote.model.reviews

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@JsonClass(generateAdapter = true)
data class ReviewDto(

    @Json(name = "id")
    val id: String,

    @Json(name = "author")
    val author: String,

    @Json(name = "author_details")
    val authorDetails: AuthorDetailsDto,

    @Json(name = "content")
    val content: String,

    @Json(name = "created_at")
    val createdAt: String
)
