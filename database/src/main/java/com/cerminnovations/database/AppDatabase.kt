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
import com.cerminnovations.database.dao.tv.popular.PopularTvDao
import com.cerminnovations.database.dao.tv.popular.PopularTvRemoteKeyDao
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
import com.cerminnovations.database.entities.tv.popular.PopularTv
import com.cerminnovations.database.entities.tv.popular.PopularTvRemoteKey
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

        /*
        * Genre
        * */
        GenreEntity::class,
    ],
    exportSchema = false,
    version = 7
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
    abstract val popularTvDao: PopularTvDao
    abstract val popularTvRemoteKeyDao: PopularTvRemoteKeyDao
}
