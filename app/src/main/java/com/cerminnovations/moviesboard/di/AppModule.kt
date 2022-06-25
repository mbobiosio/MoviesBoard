package com.cerminnovations.moviesboard.di

import androidx.paging.ExperimentalPagingApi
import com.cerminnovations.moviesboard.data.remote.repository.movies.* // ktlint-disable no-wildcard-imports
import com.cerminnovations.moviesboard.domain.repository.movies.* // ktlint-disable no-wildcard-imports
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
class AppModule {

    @Provides
    @Singleton
    @ExperimentalPagingApi
    fun provideMovieRepository(
        movieRepositoryImpl: PopularMovieRepoImpl
    ): PopularMovieRepo = movieRepositoryImpl

    @Provides
    @Singleton
    @ExperimentalPagingApi
    fun provideTopRatedRepository(
        topRatedMoviesRepoImpl: TopRatedMoviesRepoImpl
    ): TopRatedMoviesRepo = topRatedMoviesRepoImpl

    @Provides
    @Singleton
    @ExperimentalPagingApi
    fun provideUpcomingRepository(
        upcomingMoviesRepoImpl: UpcomingMoviesRepoImpl
    ): UpcomingMoviesRepo = upcomingMoviesRepoImpl

    @Provides
    @Singleton
    @ExperimentalPagingApi
    fun provideNowPlayingRepository(
        nowPlayingRepoImpl: NowPlayingRepoImpl
    ): NowPlayingMoviesRepo = nowPlayingRepoImpl

    @Provides
    @Singleton
    @ExperimentalPagingApi
    fun provideTrendingRepository(
        trendingMoviesRepoImpl: TrendingMoviesRepoImpl
    ): TrendingMoviesRepo = trendingMoviesRepoImpl
}
