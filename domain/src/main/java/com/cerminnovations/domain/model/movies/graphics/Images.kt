package com.cerminnovations.domain.model.movies.graphics

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
data class Images(
    val id: Int?,
    val backdrops: List<ImageDetails>,
    val posters: List<ImageDetails>
)
