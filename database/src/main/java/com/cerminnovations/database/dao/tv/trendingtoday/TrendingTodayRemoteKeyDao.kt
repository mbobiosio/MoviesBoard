package com.cerminnovations.database.dao.tv.trendingtoday

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.database.entities.tv.trendingtoday.TrendingTodayRemoteKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface TrendingTodayRemoteKeyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertKeys(remoteKeys: List<TrendingTodayRemoteKey>)

    @Query("SELECT * FROM trending_today_tv_remote_keys WHERE tvId = :id")
    suspend fun remoteKeyId(id: Long): TrendingTodayRemoteKey?

    @Query("DELETE FROM trending_today_tv_remote_keys")
    suspend fun deleteAll()
}
