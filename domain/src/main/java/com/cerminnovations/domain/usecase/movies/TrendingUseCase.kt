package com.cerminnovations.domain.usecase.movies

import androidx.paging.PagingData
import com.cerminnovations.domain.model.movies.MovieData
import com.cerminnovations.moviesboard.domain.repository.movies.TrendingMoviesRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class TrendingUseCase @Inject constructor(
    private val trendingMoviesRepo: TrendingMoviesRepo
) {
    operator fun invoke(): Flow<PagingData<MovieData>> =
        trendingMoviesRepo.getTrendingMovies()
}
