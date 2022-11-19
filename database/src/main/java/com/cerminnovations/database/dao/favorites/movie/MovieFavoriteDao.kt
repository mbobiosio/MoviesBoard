package com.cerminnovations.database.dao.favorites.movie

import androidx.lifecycle.LiveData
import androidx.room.*
import com.cerminnovations.database.entities.favorite.MovieFavorite
import kotlinx.coroutines.flow.Flow

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface MovieFavoriteDao {

    @Query("SELECT * FROM movie_favorites")
    fun getFavoriteMovies(): LiveData<List<MovieFavorite>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(favorite: MovieFavorite)

    @Update
    suspend fun updateData(favorite: MovieFavorite)

    @Delete
    suspend fun deleteItem(favorite: MovieFavorite)

    @Query("DELETE FROM movie_favorites")
    suspend fun deleteAll()

    @Query("SELECT * FROM movie_favorites WHERE title LIKE :query")
    fun searchFavorites(query: String): Flow<List<MovieFavorite>>
}