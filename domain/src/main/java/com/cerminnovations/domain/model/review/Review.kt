package com.cerminnovations.domain.model.review

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
data class Review(
    val id: String,
    val author: String,
    val authorDetails: AuthorDetails,
    val content: String,
    val createdAt: String
)
