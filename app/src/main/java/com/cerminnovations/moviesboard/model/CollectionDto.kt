package com.cerminnovations.moviesboard.model

import com.squareup.moshi.Json

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
data class CollectionDto(
    @Json(name = "id")
    val id: Long,

    @Json(name = "name")
    val name: String,

    @Json(name = "poster_path")
    val posterPath: String?,

    @Json(name = "backdrop_path")
    val backdropPath: String?
)
