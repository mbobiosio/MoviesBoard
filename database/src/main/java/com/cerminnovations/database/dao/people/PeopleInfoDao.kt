package com.cerminnovations.database.dao.people

import androidx.room.* // ktlint-disable no-wildcard-imports
import com.cerminnovations.database.entities.people.PeopleInfoEntity

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface PeopleInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerson(people: PeopleInfoEntity)

    @Query("SELECT * FROM people_information WHERE id =:id")
    fun getPersonInfo(id: Long): PeopleInfoEntity

    @Delete
    suspend fun deletePerson(people: PeopleInfoEntity)
}
