package com.cerminnovations.moviesboard.domain.repository

import androidx.paging.PagingData
import com.cerminnovations.moviesboard.data.local.entities.popular.PopularMovie
import kotlinx.coroutines.flow.Flow

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
interface PopularMovieRepo {
    fun getPopularMovies(): Flow<PagingData<PopularMovie>>
}
