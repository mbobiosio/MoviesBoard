package com.cerminnovations.database.entities.tv.trendingtoday

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Entity(tableName = "trending_today_tv_remote_keys")
data class TrendingTodayRemoteKey(
    @PrimaryKey
    val tvId: Long,
    val prevKey: Int?,
    val nextKey: Int?
)
