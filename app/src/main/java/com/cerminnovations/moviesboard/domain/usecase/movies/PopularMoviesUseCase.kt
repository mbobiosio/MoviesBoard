package com.cerminnovations.moviesboard.domain.usecase.movies

import androidx.paging.PagingData
import com.cerminnovations.moviesboard.domain.model.MovieData
import com.cerminnovations.moviesboard.domain.repository.movies.PopularMovieRepo
import kotlinx.coroutines.flow.Flow

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class PopularMoviesUseCase(
    private val popularMovieRepo: PopularMovieRepo
) {
    operator fun invoke(): Flow<PagingData<MovieData>> =
        popularMovieRepo.getPopularMovies()
}
