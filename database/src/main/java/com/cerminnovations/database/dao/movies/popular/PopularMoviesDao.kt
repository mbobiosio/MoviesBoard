package com.cerminnovations.database.dao.movies.popular

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.database.entities.movies.popular.PopularMovie
import kotlinx.coroutines.flow.Flow

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface PopularMoviesDao {

    @Query("SELECT * FROM popular_movies")
    fun getMovies(): PagingSource<Int, PopularMovie>

    @Query(value = """ SELECT * FROM popular_movies WHERE movieId = :id""")
    fun getMovieEntity(id: Long): Flow<PopularMovie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<PopularMovie>)

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAll()
}
