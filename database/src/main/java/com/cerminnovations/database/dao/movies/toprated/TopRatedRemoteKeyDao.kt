package com.cerminnovations.database.dao.movies.toprated

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.database.entities.movies.toprated.TopRatedRemoteDao

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface TopRatedRemoteKeyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKeys: List<TopRatedRemoteDao>)

    @Query("SELECT * FROM top_rated_movie_remote_keys WHERE movieId = :id")
    suspend fun remoteKeyId(id: Long): TopRatedRemoteDao?

    @Query("DELETE FROM top_rated_movie_remote_keys")
    suspend fun deleteAllKeys()
}
