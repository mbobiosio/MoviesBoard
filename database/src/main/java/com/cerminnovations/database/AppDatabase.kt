package com.cerminnovations.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cerminnovations.database.dao.movies.nowplaying.NowPlayingDao
import com.cerminnovations.database.dao.movies.nowplaying.NowPlayingMoviesRemoteDao
import com.cerminnovations.database.dao.movies.popular.PopularMoviesDao
import com.cerminnovations.database.dao.movies.popular.PopularRemoteKeyDao
import com.cerminnovations.database.dao.movies.toprated.TopRatedMoviesDao
import com.cerminnovations.database.dao.movies.toprated.TopRatedRemoteKeyDao
import com.cerminnovations.database.dao.movies.trending.TrendingMoviesDao
import com.cerminnovations.database.dao.movies.trending.TrendingMoviesRemoteDao
import com.cerminnovations.database.dao.movies.upcoming.UpcomingMoviesDao
import com.cerminnovations.database.dao.movies.upcoming.UpcomingMoviesRemoteDao
import com.cerminnovations.database.dao.people.PeopleDao
import com.cerminnovations.database.dao.people.PeopleInfoDao
import com.cerminnovations.database.dao.people.PeopleRemoteKeyDao
import com.cerminnovations.database.dao.tv.nowshowing.NowShowingTvDao
import com.cerminnovations.database.dao.tv.nowshowing.NowShowingTvRemoteKeyDao
import com.cerminnovations.database.dao.tv.popular.PopularTvDao
import com.cerminnovations.database.dao.tv.popular.PopularTvRemoteKeyDao
import com.cerminnovations.database.dao.tv.showingtoday.ShowingTodayDao
import com.cerminnovations.database.dao.tv.showingtoday.ShowingTodayRemoteKeyDao
import com.cerminnovations.database.dao.tv.toprated.TopRatedTvDao
import com.cerminnovations.database.dao.tv.toprated.TopRatedTvRemoteKeyDao
import com.cerminnovations.database.dao.tv.trendingtoday.TrendingTodayDao
import com.cerminnovations.database.dao.tv.trendingtoday.TrendingTodayRemoteKeyDao
import com.cerminnovations.database.dao.tv.trendingweek.TrendingWeekDao
import com.cerminnovations.database.dao.tv.trendingweek.TrendingWeekRemoteKeyDao
import com.cerminnovations.database.entities.GenreEntity
import com.cerminnovations.database.entities.movies.nowplaying.NowPlayingMovies
import com.cerminnovations.database.entities.movies.nowplaying.NowPlayingRemoteKey
import com.cerminnovations.database.entities.movies.popular.PopularMovie
import com.cerminnovations.database.entities.movies.popular.PopularRemoteKey
import com.cerminnovations.database.entities.movies.toprated.TopRatedMovie
import com.cerminnovations.database.entities.movies.toprated.TopRatedRemoteDao
import com.cerminnovations.database.entities.movies.trending.TrendingMovies
import com.cerminnovations.database.entities.movies.trending.TrendingMoviesRemoteKey
import com.cerminnovations.database.entities.movies.upcoming.UpcomingMovieRemoteKey
import com.cerminnovations.database.entities.movies.upcoming.UpcomingMovies
import com.cerminnovations.database.entities.people.PeopleEntity
import com.cerminnovations.database.entities.people.PeopleInfoEntity
import com.cerminnovations.database.entities.people.PeopleRemoteKey
import com.cerminnovations.database.entities.tv.nowshowing.NowShowing
import com.cerminnovations.database.entities.tv.nowshowing.NowShowingRemoteKey
import com.cerminnovations.database.entities.tv.popular.PopularTv
import com.cerminnovations.database.entities.tv.popular.PopularTvRemoteKey
import com.cerminnovations.database.entities.tv.showingtoday.ShowingToday
import com.cerminnovations.database.entities.tv.showingtoday.ShowingTodayRemoteKey
import com.cerminnovations.database.entities.tv.toprated.TopRatedTv
import com.cerminnovations.database.entities.tv.toprated.TopRatedTvRemoteKey
import com.cerminnovations.database.entities.tv.trendingtoday.TrendingToday
import com.cerminnovations.database.entities.tv.trendingtoday.TrendingTodayRemoteKey
import com.cerminnovations.database.entities.tv.trendingweek.TrendingWeek
import com.cerminnovations.database.entities.tv.trendingweek.TrendingWeekRemoteKey
import com.cerminnovations.database.util.TypeConverter

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Database(
    entities = [
        PopularMovie::class,
        PopularRemoteKey::class,
        TopRatedMovie::class,
        TopRatedRemoteDao::class,
        UpcomingMovies::class,
        UpcomingMovieRemoteKey::class,
        NowPlayingMovies::class,
        NowPlayingRemoteKey::class,
        TrendingMovies::class,
        TrendingMoviesRemoteKey::class,

        /*
        * Tv
        * */
        PopularTv::class,
        PopularTvRemoteKey::class,
        TopRatedTv::class,
        TopRatedTvRemoteKey::class,
        NowShowing::class,
        NowShowingRemoteKey::class,
        ShowingToday::class,
        ShowingTodayRemoteKey::class,
        TrendingToday::class,
        TrendingTodayRemoteKey::class,
        TrendingWeek::class,
        TrendingWeekRemoteKey::class,

        /*
        * People
        * */
        PeopleEntity::class,
        PeopleInfoEntity::class,
        PeopleRemoteKey::class,

        /*
        * Genre
        * */
        GenreEntity::class
    ],
    exportSchema = false,
    version = 11
)
@TypeConverters(TypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    /*
    * Movies
    * */
    // Popular Movies
    abstract val popularMoviesDao: PopularMoviesDao
    abstract val popularRemoteKeyDao: PopularRemoteKeyDao

    // Top rated movies
    abstract val topRatedMoviesDao: TopRatedMoviesDao
    abstract val topRatedRemoteKeyDao: TopRatedRemoteKeyDao

    // Upcoming movies
    abstract val upcomingMoviesDao: UpcomingMoviesDao
    abstract val upcomingMovieRemoteDao: UpcomingMoviesRemoteDao

    // Now Playing Movies
    abstract val nowPlayingDao: NowPlayingDao
    abstract val nowPlayingMovieRemoteDao: NowPlayingMoviesRemoteDao

    // Trending Movies
    abstract val trendingMoviesDao: TrendingMoviesDao
    abstract val trendingMoviesRemoteDao: TrendingMoviesRemoteDao

    /*
    * TV Series
    * */
    // Popular Series
    abstract val popularTvDao: PopularTvDao
    abstract val popularTvRemoteKeyDao: PopularTvRemoteKeyDao

    // Top rated series
    abstract val topRatedTvDao: TopRatedTvDao
    abstract val topRatedTvRemoteKeyDao: TopRatedTvRemoteKeyDao

    // Now showing
    abstract val nowShowingTvDao: NowShowingTvDao
    abstract val nowShowingTvRemoteKeyDao: NowShowingTvRemoteKeyDao

    // Showing today
    abstract val showingTodayDao: ShowingTodayDao
    abstract val showingTvRemoteKeyDao: ShowingTodayRemoteKeyDao

    // Trending today
    abstract val trendingTodayDao: TrendingTodayDao
    abstract val trendingTodayRemoteKeyDao: TrendingTodayRemoteKeyDao

    // Trending week
    abstract val trendingWeekDao: TrendingWeekDao
    abstract val trendingWeekRemoteKeyDao: TrendingWeekRemoteKeyDao

    /*
    * People
    * */
    abstract val peopleDao: PeopleDao
    abstract val peopleInfoDao: PeopleInfoDao
    abstract val peopleRemoteKeyDao: PeopleRemoteKeyDao
}
