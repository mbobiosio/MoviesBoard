package com.cerminnovations.database.dao.artist

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.database.entities.people.PeopleEntity

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface PeopleDao {
    @Query("SELECT * FROM people")
    fun getPeople(): PagingSource<Int, PeopleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(people: List<PeopleEntity>)

    @Query("DELETE FROM people")
    suspend fun deleteAll()
}
