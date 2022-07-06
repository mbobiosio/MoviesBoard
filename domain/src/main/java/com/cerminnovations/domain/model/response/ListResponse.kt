package com.cerminnovations.domain.model.response

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
data class ListResponse<T>(
    val page: Int = 0,
    val totalResults: Int = 0,
    val totalPages: Int = 0,
    val results: List<T>
) {
    val isEndOfListReached = totalResults == page
}
