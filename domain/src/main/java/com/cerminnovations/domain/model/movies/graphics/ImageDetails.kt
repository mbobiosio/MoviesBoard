package com.cerminnovations.domain.model.movies.graphics

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
data class ImageDetails(
    val aspectRatio: Double,
    val filePath: String,
    val width: Int,
    val height: Int,
    val iso631: String?,
    val voteCount: Int,
    val voteAverage: Double
)
