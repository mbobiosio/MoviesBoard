package com.cerminnovations.domain.repository.movies

import androidx.paging.PagingData
import com.cerminnovations.domain.model.movies.MovieData
import kotlinx.coroutines.flow.Flow

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
interface PopularMovieRepo {
    fun getPopularMovies(): Flow<PagingData<MovieData>>
}
