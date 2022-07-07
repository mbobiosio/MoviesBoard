package com.cerminnovations.database.dao.tv.toprated

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.database.entities.tv.toprated.TopRatedTv

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface TopRatedTvDao {

    @Query("SELECT * FROM top_rated_tv")
    fun getAll(): PagingSource<Int, TopRatedTv>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopRatedSeries(series: List<TopRatedTv>)

    @Query("DELETE FROM top_rated_tv")
    suspend fun deleteAll()
}
