package com.cerminnovations.database.entities.people

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Entity(tableName = "people_remote_key")
data class PeopleRemoteKey(
    @PrimaryKey
    val personId: Long,
    val prevKey: Int?,
    val nextKey: Int?
)
