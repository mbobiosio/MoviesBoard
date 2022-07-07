package com.cerminnovations.database.dao.tv.popular

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.database.entities.tv.popular.PopularTvRemoteKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface PopularTvRemoteKeyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertKeys(remoteKeys: List<PopularTvRemoteKey>)

    @Query("SELECT * FROM popular_tv_remote_keys WHERE tvId = :id")
    suspend fun remoteKeyId(id: Long): PopularTvRemoteKey?

    @Query("DELETE FROM popular_tv_remote_keys")
    suspend fun deleteAll()
}
