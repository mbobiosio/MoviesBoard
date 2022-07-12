package com.cerminnovations.database.dao.artist

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.database.entities.people.PeopleRemoteKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface PeopleRemoteKeyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKeys: List<PeopleRemoteKey>)

    @Query("SELECT * FROM people_remote_key WHERE personId =:id")
    suspend fun remoteKeyId(id: Long): PeopleRemoteKey?

    @Query("DELETE FROM people_remote_key")
    suspend fun deleteAll()
}
