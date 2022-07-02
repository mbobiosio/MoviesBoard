package com.cerminnovations.moviesboard.data.remote.repository.movies

import com.cerminnovations.domain.model.movies.MovieDetail
import com.cerminnovations.domain.repository.movies.MovieDetailRepository
import com.cerminnovations.moviesboard.data.mappers.MovieDetailMapper
import com.cerminnovations.moviesboard.data.remote.api.ApiService
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class MovieDetailRepoImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: MovieDetailMapper
) : MovieDetailRepository {

    override suspend fun getMovieDetails(
        movieId: Long,
        apiKey: String,
        language: String?,
        appendToResponse: String?
    ): MovieDetail {
        val data = apiService.getMovieById(movieId, apiKey, language, appendToResponse)
        return mapper.map(data)
    }
}
