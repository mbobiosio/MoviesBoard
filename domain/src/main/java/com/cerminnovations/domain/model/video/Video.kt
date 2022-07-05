package com.cerminnovations.domain.model.video

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
data class Video(
    val id: String,
    val name: String,
    val type: String,
    val iso639: String,
    val iso3166: String,
    val key: String,
    val size: Int,
    val site: String
)
