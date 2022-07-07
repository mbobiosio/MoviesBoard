package com.cerminnovations.moviesboard.data.remote.repository.movies

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.map
import com.cerminnovations.core.util.defaultPageConfig
import com.cerminnovations.database.AppDatabase
import com.cerminnovations.domain.model.movies.MovieData
import com.cerminnovations.domain.repository.movies.PopularMovieRepo
import com.cerminnovations.moviesboard.data.mappers.mapEntityToDomain
import com.cerminnovations.moviesboard.data.remote.paging.movies.PopularMoviesMediator
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
        val pagingSourceFactory = database.popularMoviesDao::getMovies

        return Pager(
            config = defaultPageConfig(),
            remoteMediator = popularMoviesMediator,
            pagingSourceFactory = pagingSourceFactory
        ).flow.map {
            it.map { entity ->
                entity.mapEntityToDomain()
            }
        }
    }
}
