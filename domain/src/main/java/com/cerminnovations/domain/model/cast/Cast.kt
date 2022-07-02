package com.cerminnovations.domain.model.cast

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
data class Cast(
    val id: Int,
    val name: String,
    val creditId: String,
    val character: String?,
    val order: Int?,
    val profilePath: String?
)
