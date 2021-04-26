package com.mbobiosio.moviesboard.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.mbobiosio.moviesboard.model.movies.Movie

/*
* Created by Mbuodile Obiosio on Jan 20, 2021.
* Twitter: @cazewonder
* Nigeria
*/
@Dao
interface MovieDAO {

    @Query("SELECT * FROM movie")
    suspend fun getMovieList(): List<Movie>?

    @Query("SELECT * FROM movie WHERE movie.id = :id")
    suspend fun getMovie(id: String): Movie?

    @Insert(onConflict = IGNORE)
    suspend fun insert(movie: Movie)

    @Insert(onConflict = IGNORE)
    suspend fun inset(list: List<Movie>)

    @Insert(onConflict = REPLACE)
    suspend fun update(movie: Movie)

    @Delete
    suspend fun deleteMovie(movie: Movie)

    @Query("DELETE FROM movie WHERE id = :id")
    suspend fun deleteMovie(id: String)

    @Query("DELETE FROM movie")
    suspend fun deleteAll()

    @Query("SELECT * FROM movie LIMIT :pageSize OFFSET :pageIndex")
    suspend fun getMoviePage(pageSize: Int, pageIndex: Int): List<Movie>?

    @Query("SELECT * FROM movie WHERE movie.isFavorite = 1 LIMIT :pageSize OFFSET ((:pageIndex-1)*:pageSize) ")
    suspend fun getFavorite(pageSize: Int, pageIndex: Int): List<Movie>?
}