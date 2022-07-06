package com.cerminnovations.moviesboard.di

import androidx.paging.ExperimentalPagingApi
import com.cerminnovations.domain.repository.movies.MovieDetailRepository
import com.cerminnovations.domain.repository.movies.NowPlayingMoviesRepo
import com.cerminnovations.domain.repository.movies.PopularMovieRepo
import com.cerminnovations.domain.repository.series.PopularTvRepo
import com.cerminnovations.moviesboard.data.mappers.MovieDetailMapper
import com.cerminnovations.moviesboard.data.remote.repository.movies.* // ktlint-disable no-wildcard-imports
import com.cerminnovations.moviesboard.data.remote.repository.tv.PopularTvRepoImpl
import com.cerminnovations.moviesboard.domain.repository.movies.TopRatedMoviesRepo
import com.cerminnovations.moviesboard.domain.repository.movies.TrendingMoviesRepo
import com.cerminnovations.moviesboard.domain.repository.movies.UpcomingMoviesRepo
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

    @Provides
    @Singleton
    fun provideMovieDetailRepository(
        movieDetailRepoImpl: MovieDetailRepoImpl
    ): MovieDetailRepository = movieDetailRepoImpl

    /*
    * Tv
    * */
    @Provides
    @Singleton
    @ExperimentalPagingApi
    fun providePopularTvRepository(
        popularTvRepoImpl: PopularTvRepoImpl
    ): PopularTvRepo = popularTvRepoImpl

    @Provides
    @Singleton
    fun provideMovieDetailDTOMapper() = MovieDetailMapper()
}
