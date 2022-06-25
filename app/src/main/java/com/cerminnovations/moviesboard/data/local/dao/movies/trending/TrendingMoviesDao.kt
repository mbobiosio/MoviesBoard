package com.cerminnovations.moviesboard.data.local.dao.movies.trending

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.moviesboard.data.local.entities.movies.trending.TrendingMovies

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface TrendingMoviesDao {

    @Query("SELECT * FROM trending_movies")
    fun getTrendingMovies(): PagingSource<Int, TrendingMovies>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<TrendingMovies>)

    @Query("DELETE FROM trending_movies")
    suspend fun deleteAll()
}
