package com.cerminnovations.database.dao.tv.showingtoday

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.database.entities.tv.showingtoday.ShowingToday

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface ShowingTodayDao {

    @Query("SELECT * FROM showing_today_tv")
    fun getAll(): PagingSource<Int, ShowingToday>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShowingToday(series: List<ShowingToday>)

    @Query("DELETE FROM showing_today_tv")
    suspend fun deleteAll()
}
