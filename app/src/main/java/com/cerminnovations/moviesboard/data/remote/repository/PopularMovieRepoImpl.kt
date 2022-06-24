package com.cerminnovations.moviesboard.data.remote.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.cerminnovations.moviesboard.data.local.AppDatabase
import com.cerminnovations.moviesboard.data.local.entities.popular.PopularMovie
import com.cerminnovations.moviesboard.data.remote.paging.PopularMoviesMediator
import com.cerminnovations.moviesboard.domain.repository.PopularMovieRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@ExperimentalPagingApi
class PopularMovieRepoImpl @Inject constructor(
    private val database: AppDatabase,
    private val popularMoviesMediator: PopularMoviesMediator
) : PopularMovieRepo {

    override fun getPopularMovies(): Flow<PagingData<PopularMovie>> {
        val pagingSourceFactory = { database.popularMoviesDao.getMovies() }

        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = true,
                prefetchDistance = 5,
                initialLoadSize = 40
            ),
            remoteMediator = popularMoviesMediator,
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }
}
