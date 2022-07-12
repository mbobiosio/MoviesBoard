package com.cerminnovations.database.entities.people

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Entity(tableName = "people")
data class PeopleEntity(
    val id: Long,
    val profilePath: String?,
    @PrimaryKey
    val name: String,
    val popularity: Double?,
    val knownForDepartment: String?
)
