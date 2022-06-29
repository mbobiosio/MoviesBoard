package com.cerminnovations.domain.usecase.movies

import androidx.paging.PagingData
import com.cerminnovations.domain.model.MovieData
import com.cerminnovations.moviesboard.domain.repository.movies.NowPlayingMoviesRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class NowPlayingUseCase @Inject constructor(
    private val nowPlayingMoviesRepo: NowPlayingMoviesRepo
) {
    operator fun invoke(): Flow<PagingData<MovieData>> =
        nowPlayingMoviesRepo.getNowPlaying()
}
