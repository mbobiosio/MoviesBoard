package com.cerminnovations.moviesboard.di

import androidx.paging.ExperimentalPagingApi
import com.cerminnovations.moviesboard.domain.repository.movies.* // ktlint-disable no-wildcard-imports
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

    fun provideMoviesUseCase(
        popularMovieRepo: PopularMovieRepo
    ): PopularMoviesUseCase = PopularMoviesUseCase(popularMovieRepo)

    @Provides
    @Singleton
    fun provideTopRatedUseCase(
        topRatedMoviesRepo: TopRatedMoviesRepo
    ): TopRatedUseCase = TopRatedUseCase(topRatedMoviesRepo)

    @Provides
    @Singleton
    fun provideUpcomingMovieUseCase(
        upcomingMoviesRepo: UpcomingMoviesRepo
    ): UpcomingMoviesUseCase = UpcomingMoviesUseCase(upcomingMoviesRepo)

    @Provides
    @Singleton
    fun provideNowPlayingMovieUseCase(
        nowPlayingMoviesRepo: NowPlayingMoviesRepo
    ): NowPlayingUseCase = NowPlayingUseCase(nowPlayingMoviesRepo)

    @Provides
    @Singleton
    fun provideTrendingMoviesUseCase(
        trendingMoviesRepo: TrendingMoviesRepo
    ): TrendingUseCase = TrendingUseCase(trendingMoviesRepo)
}
