package com.cerminnovations.moviesboard.domain.usecase.movies

import androidx.paging.PagingData
import com.cerminnovations.moviesboard.domain.model.MovieData
import com.cerminnovations.moviesboard.domain.repository.movies.UpcomingMoviesRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class UpcomingMoviesUseCase @Inject constructor(
    private val upcomingMoviesRepo: UpcomingMoviesRepo
) {
    operator fun invoke(): Flow<PagingData<MovieData>> =
        upcomingMoviesRepo.getUpcomingMovies()
}
