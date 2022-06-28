package com.cerminnovations.moviesboard.data.remote.repository.movies

import androidx.paging.* // ktlint-disable no-wildcard-imports
import com.cerminnovations.moviesboard.data.local.AppDatabase
import com.cerminnovations.moviesboard.data.mappers.mapEntityToDomain
import com.cerminnovations.moviesboard.data.remote.paging.movies.NowPlayingMediator
import com.cerminnovations.moviesboard.domain.model.MovieData
import com.cerminnovations.moviesboard.domain.repository.movies.NowPlayingMoviesRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@ExperimentalPagingApi
class NowPlayingRepoImpl @Inject constructor(
    private val database: AppDatabase,
    private val nowPlayingMediator: NowPlayingMediator
) : NowPlayingMoviesRepo {

    override fun getNowPlaying(): Flow<PagingData<MovieData>> {
        val pagingSourceFactory = {
            database.nowPlayingDao.getNowPlayingMovies()
        }

        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = true,
                prefetchDistance = 5,
                initialLoadSize = 40
            ),
            remoteMediator = nowPlayingMediator,
            pagingSourceFactory = pagingSourceFactory
        ).flow.map {
            it.map { entity ->
                entity.mapEntityToDomain()
            }
        }
    }
}