package com.cerminnovations.domain.usecase.movies

import androidx.paging.PagingData
import com.cerminnovations.domain.model.movies.MovieData
import com.cerminnovations.moviesboard.domain.repository.movies.TopRatedMoviesRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class TopRatedUseCase @Inject constructor(
    private val topRatedMoviesRepo: TopRatedMoviesRepo
) {
    operator fun invoke(): Flow<PagingData<MovieData>> =
        topRatedMoviesRepo.getTopRatedMovies()
}
