package com.cerminnovations.domain.repository.movies

import com.cerminnovations.domain.model.MovieDetail

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
interface MovieDetailRepository {

    suspend fun getMovieDetails(
        movieId: Long,
        apiKey: String,
        language: String?,
        appendToResponse: String?
    ): MovieDetail
}
