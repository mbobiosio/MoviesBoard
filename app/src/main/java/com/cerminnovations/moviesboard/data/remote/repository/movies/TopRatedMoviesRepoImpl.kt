package com.cerminnovations.moviesboard.data.remote.repository.movies

import androidx.paging.* // ktlint-disable no-wildcard-imports
import com.cerminnovations.domain.model.MovieData
import com.cerminnovations.moviesboard.data.local.AppDatabase
import com.cerminnovations.moviesboard.data.mappers.mapEntityToDomain
import com.cerminnovations.moviesboard.data.remote.paging.movies.TopRatedMoviesMediator
import com.cerminnovations.moviesboard.domain.repository.movies.TopRatedMoviesRepo
import com.cerminnovations.moviesboard.util.defaultPageConfig
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@ExperimentalPagingApi
class TopRatedMoviesRepoImpl @Inject constructor(
    private val database: AppDatabase,
    private val topRatedMoviesMediator: TopRatedMoviesMediator
) : TopRatedMoviesRepo {

    override fun getTopRatedMovies(): Flow<PagingData<MovieData>> {
        val pagingSourceFactory = {
            database.topRatedMoviesDao.getTopRatedMovies()
        }

        return Pager(
            config = defaultPageConfig(),
            remoteMediator = topRatedMoviesMediator,
            pagingSourceFactory = pagingSourceFactory
        ).flow.map {
            it.map { entity ->
                entity.mapEntityToDomain()
            }
        }
    }
}
