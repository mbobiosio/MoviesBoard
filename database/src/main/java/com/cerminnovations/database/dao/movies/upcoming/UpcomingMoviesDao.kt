package com.cerminnovations.database.dao.movies.upcoming

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.database.entities.movies.upcoming.UpcomingMovies

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface UpcomingMoviesDao {

    @Query("SELECT * FROM upcoming_movies")
    fun getUpcomingMovies(): PagingSource<Int, UpcomingMovies>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<UpcomingMovies>)

    @Query("DELETE FROM upcoming_movies")
    suspend fun deleteAll()
}
