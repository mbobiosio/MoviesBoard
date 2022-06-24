package com.cerminnovations.moviesboard.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cerminnovations.moviesboard.data.local.dao.PopularMoviesDao
import com.cerminnovations.moviesboard.data.local.dao.PopularRemoteKeyDao
import com.cerminnovations.moviesboard.data.local.entities.GenreEntity
import com.cerminnovations.moviesboard.data.local.entities.popular.PopularMovie
import com.cerminnovations.moviesboard.data.local.entities.popular.PopularRemoteKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Database(
    entities = [PopularMovie::class, GenreEntity::class, PopularRemoteKey::class],
    exportSchema = false,
    version = 4
)
@TypeConverters(TypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val popularMoviesDao: PopularMoviesDao
    abstract val popularRemoteKeyDao: PopularRemoteKeyDao
}
