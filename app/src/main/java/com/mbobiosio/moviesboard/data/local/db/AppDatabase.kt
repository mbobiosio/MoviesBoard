package com.mbobiosio.moviesboard.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mbobiosio.moviesboard.data.local.dao.MovieDAO
import com.mbobiosio.moviesboard.model.movies.Movie

/*
* Created by Mbuodile Obiosio on Jan 20, 2021.
* Twitter: @cazewonder
* Nigeria
*/
@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDAO
}