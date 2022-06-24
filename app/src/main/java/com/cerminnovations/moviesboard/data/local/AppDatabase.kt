package com.cerminnovations.moviesboard.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cerminnovations.moviesboard.data.local.dao.movies.popular.PopularMoviesDao
import com.cerminnovations.moviesboard.data.local.dao.movies.popular.PopularRemoteKeyDao
import com.cerminnovations.moviesboard.data.local.dao.movies.toprated.TopRatedMoviesDao
import com.cerminnovations.moviesboard.data.local.dao.movies.toprated.TopRatedRemoteKeyDao
import com.cerminnovations.moviesboard.data.local.entities.GenreEntity
import com.cerminnovations.moviesboard.data.local.entities.movies.popular.PopularMovie
import com.cerminnovations.moviesboard.data.local.entities.movies.popular.PopularRemoteKey
import com.cerminnovations.moviesboard.data.local.entities.movies.toprated.TopRatedMovie
import com.cerminnovations.moviesboard.data.local.entities.movies.toprated.TopRatedRemoteEntity

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Database(
    entities = [
        PopularMovie::class,
        PopularRemoteKey::class,
        TopRatedMovie::class,
        TopRatedRemoteEntity::class,
        GenreEntity::class,
    ],
    exportSchema = false,
    version = 5
)
@TypeConverters(TypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    /*
    * Movies
    * */
    // Movies
    abstract val popularMoviesDao: PopularMoviesDao
    abstract val popularRemoteKeyDao: PopularRemoteKeyDao
    abstract val topRatedMoviesDao: TopRatedMoviesDao
    abstract val topRatedRemoteKeyDao: TopRatedRemoteKeyDao
}
