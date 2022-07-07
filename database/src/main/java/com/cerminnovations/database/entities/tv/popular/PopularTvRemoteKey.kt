package com.cerminnovations.database.entities.tv.popular

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Entity(tableName = "popular_tv_remote_keys")
data class PopularTvRemoteKey(
    @PrimaryKey
    val tvId: Long,
    val prevKey: Int?,
    val nextKey: Int?
)
