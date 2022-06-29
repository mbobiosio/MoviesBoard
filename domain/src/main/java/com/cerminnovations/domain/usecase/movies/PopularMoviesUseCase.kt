package com.cerminnovations.domain.usecase.movies

import androidx.paging.PagingData
import com.cerminnovations.domain.model.MovieData
import com.cerminnovations.moviesboard.domain.repository.movies.PopularMovieRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class PopularMoviesUseCase @Inject constructor(
    private val popularMovieRepo: PopularMovieRepo
) {
    operator fun invoke(): Flow<PagingData<MovieData>> =
        popularMovieRepo.getPopularMovies()
}
