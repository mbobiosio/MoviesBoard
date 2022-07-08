package com.cerminnovations.database.entities.tv.upcoming

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Entity(tableName = "upcoming_tv_remote_key")
data class UpcomingTvRemoteKey(
    @PrimaryKey
    val tvId: Long,
    val prevKey: Int?,
    val nextKey: Int?
)
