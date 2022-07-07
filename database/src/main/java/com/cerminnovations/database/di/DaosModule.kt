package com.cerminnovations.database.di

import com.cerminnovations.database.AppDatabase
import com.cerminnovations.database.dao.movies.nowplaying.NowPlayingDao
import com.cerminnovations.database.dao.movies.popular.PopularMoviesDao
import com.cerminnovations.database.dao.movies.toprated.TopRatedMoviesDao
import com.cerminnovations.database.dao.movies.trending.TrendingMoviesDao
import com.cerminnovations.database.dao.movies.upcoming.UpcomingMoviesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Module
@InstallIn(SingletonComponent::class)
object DaosModule {

    @Provides
    fun provideMoviesDao(
        appDatabase: AppDatabase
    ): PopularMoviesDao = appDatabase.popularMoviesDao

    @Provides
    fun provideTopRatedMoviesDao(
        appDatabase: AppDatabase
    ): TopRatedMoviesDao = appDatabase.topRatedMoviesDao

    @Provides
    fun provideUpcomingMoviesDao(
        appDatabase: AppDatabase
    ): UpcomingMoviesDao = appDatabase.upcomingMoviesDao

    @Provides
    fun provideNowPlayingMoviesDao(
        appDatabase: AppDatabase
    ): NowPlayingDao = appDatabase.nowPlayingDao

    @Provides
    fun provideTrendingMoviesDao(
        appDatabase: AppDatabase
    ): TrendingMoviesDao = appDatabase.trendingMoviesDao
}
