package com.cerminnovations.database.di

import com.cerminnovations.database.AppDatabase
import com.cerminnovations.database.dao.movies.nowplaying.NowPlayingDao
import com.cerminnovations.database.dao.movies.popular.PopularMoviesDao
import com.cerminnovations.database.dao.movies.toprated.TopRatedMoviesDao
import com.cerminnovations.database.dao.movies.trending.TrendingMoviesDao
import com.cerminnovations.database.dao.movies.upcoming.UpcomingMoviesDao
import com.cerminnovations.database.dao.tv.nowshowing.NowShowingTvDao
import com.cerminnovations.database.dao.tv.popular.PopularTvDao
import com.cerminnovations.database.dao.tv.showingtoday.ShowingTodayDao
import com.cerminnovations.database.dao.tv.toprated.TopRatedTvDao
import com.cerminnovations.database.dao.tv.trendingtoday.TrendingTodayDao
import com.cerminnovations.database.dao.tv.trendingweek.TrendingWeekDao
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

    /*
    * Movies
    * */
    @Provides
    fun providePopularMoviesDao(
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

    /*
    * TV
    * */
    @Provides
    fun providePopularSeriesDao(
        appDatabase: AppDatabase
    ): PopularTvDao = appDatabase.popularTvDao

    @Provides
    fun provideTopRatedSeriesDao(
        appDatabase: AppDatabase
    ): TopRatedTvDao = appDatabase.topRatedTvDao

    @Provides
    fun provideNowShowingSeriesDao(
        appDatabase: AppDatabase
    ): NowShowingTvDao = appDatabase.nowShowingTvDao

    @Provides
    fun provideShowingTodaySeriesDao(
        appDatabase: AppDatabase
    ): ShowingTodayDao = appDatabase.showingTodayDao

    @Provides
    fun provideTrendingTodaySeriesDao(
        appDatabase: AppDatabase
    ): TrendingTodayDao = appDatabase.trendingTodayDao

    @Provides
    fun provideTrendingWeekSeriesDao(
        appDatabase: AppDatabase
    ): TrendingWeekDao = appDatabase.trendingWeekDao
}
