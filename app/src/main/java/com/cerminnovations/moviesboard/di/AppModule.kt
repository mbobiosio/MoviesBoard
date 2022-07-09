package com.cerminnovations.moviesboard.di

import androidx.paging.ExperimentalPagingApi
import com.cerminnovations.domain.repository.movies.MovieDetailRepository
import com.cerminnovations.domain.repository.movies.NowPlayingMoviesRepo
import com.cerminnovations.domain.repository.movies.PopularMovieRepo
import com.cerminnovations.domain.repository.tv.* // ktlint-disable no-wildcard-imports
import com.cerminnovations.moviesboard.data.mappers.MovieDetailMapper
import com.cerminnovations.moviesboard.data.mappers.TvDetailMapper
import com.cerminnovations.moviesboard.data.remote.repository.movies.* // ktlint-disable no-wildcard-imports
import com.cerminnovations.moviesboard.data.remote.repository.tv.* // ktlint-disable no-wildcard-imports
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
    @ExperimentalPagingApi
    fun provideTopRatedTvRepository(
        topRatedTvRepoImpl: TopRatedTvRepoImpl
    ): TopRatedTvRepo = topRatedTvRepoImpl

    @Provides
    @Singleton
    @ExperimentalPagingApi
    fun provideNowShowingTvRepository(
        nowShowingTvRepoImpl: NowShowingTvRepoImpl
    ): NowShowingTvRepo = nowShowingTvRepoImpl

    @Provides
    @Singleton
    @ExperimentalPagingApi
    fun provideShowingTodayTvRepository(
        showingTodayTvRepoImpl: ShowingTodayTvRepoImpl
    ): ShowingTodayTvRepo = showingTodayTvRepoImpl

    @Provides
    @Singleton
    @ExperimentalPagingApi
    fun provideTrendingTodayTvRepository(
        trendingTodayTvRepoImpl: TrendingTodayTvRepoImpl
    ): TrendingTodayTvRepo = trendingTodayTvRepoImpl

    @Provides
    @Singleton
    @ExperimentalPagingApi
    fun provideTrendingWeekTvRepository(
        trendingWeekRepoImpl: TrendingWeekRepoImpl
    ): TrendingWeekTvRepo = trendingWeekRepoImpl

    @Provides
    @Singleton
    fun provideSeriesDetailRepository(
        seriesDetailRepoImpl: SeriesDetailRepoImpl
    ): SeriesDetailRepository = seriesDetailRepoImpl

    @Provides
    @Singleton
    fun provideMovieDetailDTOMapper() = MovieDetailMapper()

    @Provides
    @Singleton
    fun provideTvDetailDtoMapper() = TvDetailMapper()
}
