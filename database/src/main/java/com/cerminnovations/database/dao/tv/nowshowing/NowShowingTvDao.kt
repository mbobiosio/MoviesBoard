package com.cerminnovations.database.dao.tv.nowshowing

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.database.entities.tv.nowshowing.NowShowing

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface NowShowingTvDao {

    @Query("SELECT * FROM now_showing_tv")
    fun getAll(): PagingSource<Int, NowShowing>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNowShowing(series: List<NowShowing>)

    @Query("DELETE FROM now_showing_tv")
    suspend fun deleteAll()
}
