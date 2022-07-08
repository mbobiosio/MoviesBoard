package com.cerminnovations.database.dao.tv.showingtoday

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.database.entities.tv.showingtoday.ShowingTodayRemoteKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface ShowingTodayRemoteKeyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertKeys(remoteKeys: List<ShowingTodayRemoteKey>)

    @Query("SELECT * FROM showing_today_tv_remote_keys WHERE tvId = :id")
    suspend fun remoteKeyId(id: Long): ShowingTodayRemoteKey?

    @Query("DELETE FROM showing_today_tv_remote_keys")
    suspend fun deleteAll()
}
