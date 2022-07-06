package com.cerminnovations.moviesboard.data.remote.repository.movies

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.map
import com.cerminnovations.core.util.defaultPageConfig
import com.cerminnovations.domain.model.movies.MovieData
import com.cerminnovations.moviesboard.data.local.AppDatabase
import com.cerminnovations.moviesboard.data.mappers.mapEntityToDomain
import com.cerminnovations.moviesboard.data.remote.paging.movies.TrendingMediator
import com.cerminnovations.moviesboard.domain.repository.movies.TrendingMoviesRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@ExperimentalPagingApi
class TrendingMoviesRepoImpl @Inject constructor(
    private val database: AppDatabase,
    private val trendingMediator: TrendingMediator
) : TrendingMoviesRepo {

    override fun getTrendingMovies(): Flow<PagingData<MovieData>> {
        val pagingSourceFactory = {
            database.trendingMoviesDao.getTrendingMovies()
        }

        return Pager(
            config = defaultPageConfig(),
            remoteMediator = trendingMediator,
            pagingSourceFactory = pagingSourceFactory
        ).flow.map {
            it.map { entity ->
                entity.mapEntityToDomain()
            }
        }
    }
}
