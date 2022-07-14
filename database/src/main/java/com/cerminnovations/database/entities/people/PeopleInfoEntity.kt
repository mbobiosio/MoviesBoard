package com.cerminnovations.database.entities.people

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Entity(tableName = "people_information")
data class PeopleInfoEntity(
    @PrimaryKey
    val id: Int?,
    val name: String?,
    val birthday: String?,
    val gender: Int?,
    val knownForDepartment: String?,
    val deathday: String?,
    val biography: String?,
    val popularity: Double?,
    val placeOfBirth: String?,
    val profilePath: String?,
    val isAdult: Boolean?,
    val imdbId: String?,
    val homepage: String?,
    val alsoKnownAs: List<String>?
)
