package com.cerminnovations.moviesboard.domain.usecase

import androidx.paging.PagingData
import com.cerminnovations.moviesboard.data.local.entities.popular.PopularMovie
import com.cerminnovations.moviesboard.domain.repository.PopularMovieRepo
import kotlinx.coroutines.flow.Flow

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class PopularMoviesUseCase(
    private val popularMovieRepo: PopularMovieRepo
) {
    operator fun invoke(): Flow<PagingData<PopularMovie>> =
        popularMovieRepo.getPopularMovies()
}
