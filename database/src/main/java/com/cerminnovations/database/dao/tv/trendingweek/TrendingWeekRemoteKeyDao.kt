package com.cerminnovations.database.dao.tv.trendingweek

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.database.entities.tv.trendingweek.TrendingWeekRemoteKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface TrendingWeekRemoteKeyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertKeys(remoteKeys: List<TrendingWeekRemoteKey>)

    @Query("SELECT * FROM trending_week_tv_remote_keys WHERE tvId = :id")
    suspend fun remoteKeyId(id: Long): TrendingWeekRemoteKey?

    @Query("DELETE FROM trending_week_tv_remote_keys")
    suspend fun deleteAll()
}
