package com.cerminnovations.moviesboard.domain.usecase.movies

import androidx.paging.PagingData
import com.cerminnovations.moviesboard.domain.model.MovieData
import com.cerminnovations.moviesboard.domain.repository.movies.TopRatedMoviesRepo
import kotlinx.coroutines.flow.Flow

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class TopRatedUseCase(
    private val topRatedMoviesRepo: TopRatedMoviesRepo
) {
    operator fun invoke(): Flow<PagingData<MovieData>> =
        topRatedMoviesRepo.getTopRatedMovies()
}
