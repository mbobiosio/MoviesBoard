package com.cerminnovations.moviesboard.data.local.dao.movies.toprated

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.moviesboard.data.local.entities.movies.toprated.TopRatedRemoteEntity

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface TopRatedRemoteKeyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKeys: List<TopRatedRemoteEntity>)

    @Query("SELECT * FROM top_rated_movie_remote_keys WHERE movieId = :id")
    suspend fun remoteKeyId(id: Long): TopRatedRemoteEntity?

    @Query("DELETE FROM TOP_RATED_MOVIE_REMOTE_KEYS")
    suspend fun deleteAllKeys()
}
