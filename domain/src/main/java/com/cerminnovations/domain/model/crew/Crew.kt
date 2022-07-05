package com.cerminnovations.domain.model.crew

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
data class Crew(
    val id: Int,
    val creditId: String,
    val name: String,
    val department: String,
    val job: String,
    val profilePath: String?,
    val gender: Int
)
