package com.cerminnovations.database.dao.movies.popular

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.database.entities.movies.popular.PopularRemoteKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface PopularRemoteKeyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<PopularRemoteKey>)

    @Query("SELECT * FROM popular_movie_remote_keys WHERE movieId = :id")
    suspend fun remoteKeyId(id: Long): PopularRemoteKey?

    @Query("DELETE FROM popular_movie_remote_keys")
    suspend fun deleteAll()
}
