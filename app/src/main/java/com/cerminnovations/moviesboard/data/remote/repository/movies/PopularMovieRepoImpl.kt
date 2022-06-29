package com.cerminnovations.moviesboard.data.remote.repository.movies

import androidx.paging.* // ktlint-disable no-wildcard-imports
import com.cerminnovations.domain.model.MovieData
import com.cerminnovations.moviesboard.data.local.AppDatabase
import com.cerminnovations.moviesboard.data.mappers.mapEntityToDomain
import com.cerminnovations.moviesboard.data.remote.paging.movies.PopularMoviesMediator
import com.cerminnovations.moviesboard.domain.repository.movies.PopularMovieRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
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

    override fun getPopularMovies(): Flow<PagingData<MovieData>> {
        val pagingSourceFactory = {
            database.popularMoviesDao.getMovies()
        }

        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = true,
                prefetchDistance = 5,
                initialLoadSize = 40
            ),
            remoteMediator = popularMoviesMediator,
            pagingSourceFactory = pagingSourceFactory
        ).flow.map {
            it.map { entity ->
                entity.mapEntityToDomain()
            }
        }
    }
}
