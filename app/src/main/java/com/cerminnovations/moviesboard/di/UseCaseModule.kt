package com.cerminnovations.moviesboard.di

import androidx.paging.ExperimentalPagingApi
import com.cerminnovations.moviesboard.data.remote.repository.movies.* // ktlint-disable no-wildcard-imports
import com.cerminnovations.moviesboard.domain.usecase.UseCases
import com.cerminnovations.moviesboard.domain.usecase.movies.* // ktlint-disable no-wildcard-imports
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Module
@InstallIn(SingletonComponent::class)
@ExperimentalPagingApi
class UseCaseModule {

    @Provides
    @Singleton
    fun provideUseCases(
        popularMovieRepositoryImpl: PopularMovieRepoImpl,
        topRatedMoviesRepoImpl: TopRatedMoviesRepoImpl,
        upcomingMoviesRepoImpl: UpcomingMoviesRepoImpl,
        nowPlayingRepoImpl: NowPlayingRepoImpl,
        trendingMoviesRepoImpl: TrendingMoviesRepoImpl
    ) =
        UseCases(
            getPopularMovies = PopularMoviesUseCase(popularMovieRepositoryImpl),
            getTopRatedUseCase = TopRatedUseCase(topRatedMoviesRepoImpl),
            getUpcomingMoviesUseCase = UpcomingMoviesUseCase(upcomingMoviesRepoImpl),
            getNowPlayingUseCase = NowPlayingUseCase(nowPlayingRepoImpl),
            getTrendingUseCase = TrendingUseCase(trendingMoviesRepoImpl)
        )
}
