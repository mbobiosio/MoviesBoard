package com.cerminnovations.moviesboard.data.local.dao.movies.popular

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.moviesboard.data.local.entities.movies.popular.PopularMovie

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface PopularMoviesDao {

    @Query("SELECT * FROM popular_movies")
    fun getMovies(): PagingSource<Int, PopularMovie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<PopularMovie>)

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAll()
}
