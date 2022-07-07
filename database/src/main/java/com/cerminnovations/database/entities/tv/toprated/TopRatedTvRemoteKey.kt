package com.cerminnovations.database.entities.tv.toprated

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Entity(tableName = "top_rated_tv_remote_keys")
data class TopRatedTvRemoteKey(
    @PrimaryKey
    val tvId: Long,
    val prevKey: Int?,
    val nextKey: Int?
)
