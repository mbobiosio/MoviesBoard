package com.cerminnovations.moviesboard.domain.repository.movies

import androidx.paging.PagingData
import com.cerminnovations.domain.model.MovieData
import kotlinx.coroutines.flow.Flow

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
interface UpcomingMoviesRepo {
    fun getUpcomingMovies(): Flow<PagingData<MovieData>>
}
