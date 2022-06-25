package com.cerminnovations.moviesboard.data.local.dao.movies.upcoming

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.moviesboard.data.local.entities.movies.upcoming.UpcomingMovieRemoteKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface UpcomingMoviesRemoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKeys: List<UpcomingMovieRemoteKey>)

    @Query("SELECT * FROM upcoming_movies_remote_keys WHERE movieId = :id")
    suspend fun remoteKeyId(id: Long): UpcomingMovieRemoteKey?

    @Query("DELETE FROM upcoming_movies_remote_keys")
    suspend fun deleteAllKeys()
}
