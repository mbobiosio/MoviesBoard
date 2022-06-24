package com.cerminnovations.moviesboard.data.local.dao.movies.toprated

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.moviesboard.data.local.entities.movies.toprated.TopRatedMovie

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface TopRatedMoviesDao {

    @Query("SELECT * FROM top_rated_movies")
    fun getTopRatedMovies(): PagingSource<Int, TopRatedMovie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<TopRatedMovie>)

    @Query("DELETE FROM top_rated_movies")
    suspend fun deleteAll()
}
