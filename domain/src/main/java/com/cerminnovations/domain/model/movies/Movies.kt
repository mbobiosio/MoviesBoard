package com.cerminnovations.domain.model.movies

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
data class Movies<T>(
    val total: Int = 0,
    val page: Int = 0,
    val movies: List<T>
) {
    val isEndOfListReached = total == page
}
