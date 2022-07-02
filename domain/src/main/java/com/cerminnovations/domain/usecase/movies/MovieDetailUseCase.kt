package com.cerminnovations.domain.usecase.movies

import com.cerminnovations.core.util.Resource
import com.cerminnovations.core.util.network.safeApiCall
import com.cerminnovations.domain.model.movies.MovieDetail
import com.cerminnovations.domain.repository.movies.MovieDetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class MovieDetailUseCase @Inject constructor(
    private val movieDetailRepository: MovieDetailRepository
) {
    operator fun invoke(
        movieId: Long,
        apiKey: String,
        language: String?,
        appendToResponse: String?
    ): Flow<Resource<MovieDetail>> = flow {

        emit(
            safeApiCall {
                movieDetailRepository.getMovieDetails(
                    movieId, apiKey, language, appendToResponse
                )
            }
        )
    }.flowOn(Dispatchers.IO)
}
