package com.cerminnovations.database.dao.tv.toprated

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.database.entities.tv.toprated.TopRatedTvRemoteKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface TopRatedTvRemoteKeyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertKeys(remoteKeys: List<TopRatedTvRemoteKey>)

    @Query("SELECT * FROM top_rated_tv_remote_keys WHERE tvId = :id")
    suspend fun remoteKeyId(id: Long): TopRatedTvRemoteKey?

    @Query("DELETE FROM top_rated_tv_remote_keys")
    suspend fun deleteAll()
}
