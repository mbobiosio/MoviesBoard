package com.cerminnovations.moviesboard.data.remote.repository.movies

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.map
import com.cerminnovations.core.util.defaultPageConfig
import com.cerminnovations.database.AppDatabase
import com.cerminnovations.domain.model.movies.MovieData
import com.cerminnovations.moviesboard.data.mappers.mapEntityToDomain
import com.cerminnovations.moviesboard.data.remote.paging.movies.UpcomingMoviesMediator
import com.cerminnovations.moviesboard.domain.repository.movies.UpcomingMoviesRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@ExperimentalPagingApi
class UpcomingMoviesRepoImpl @Inject constructor(
    private val database: AppDatabase,
    private val upcomingMoviesMediator: UpcomingMoviesMediator
) : UpcomingMoviesRepo {

    override fun getUpcomingMovies(): Flow<PagingData<MovieData>> {
        val pagingSourceFactory = {
            database.upcomingMoviesDao.getUpcomingMovies()
        }

        return Pager(
            config = defaultPageConfig(),
            remoteMediator = upcomingMoviesMediator,
            pagingSourceFactory = pagingSourceFactory
        ).flow.map {
            it.map { entity ->
                entity.mapEntityToDomain()
            }
        }
    }
}
