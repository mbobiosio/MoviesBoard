package com.cerminnovations.database.dao.tv.nowshowing

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.database.entities.tv.nowshowing.NowShowingRemoteKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface NowShowingTvRemoteKeyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertKeys(remoteKeys: List<NowShowingRemoteKey>)

    @Query("SELECT * FROM now_showing_tv_remote_keys WHERE tvId =:id")
    suspend fun remoteKeyId(id: Long): NowShowingRemoteKey?

    @Query("DELETE FROM now_showing_tv_remote_keys")
    suspend fun deleteAll()
}
