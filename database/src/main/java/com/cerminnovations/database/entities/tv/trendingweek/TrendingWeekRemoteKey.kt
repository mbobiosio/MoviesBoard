package com.cerminnovations.database.entities.tv.trendingweek

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Entity(tableName = "trending_week_tv_remote_keys")
data class TrendingWeekRemoteKey(
    @PrimaryKey
    val tvId: Long,
    val prevKey: Int?,
    val nextKey: Int?
)
