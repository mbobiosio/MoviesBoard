package com.cerminnovations.database.dao.movies.nowplaying

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.database.entities.movies.nowplaying.NowPlayingMovies

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface NowPlayingDao {

    @Query("SELECT * FROM now_playing_movies")
    fun getNowPlayingMovies(): PagingSource<Int, NowPlayingMovies>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<NowPlayingMovies>)

    @Query("DELETE FROM now_playing_movies")
    suspend fun deleteAll()
}
