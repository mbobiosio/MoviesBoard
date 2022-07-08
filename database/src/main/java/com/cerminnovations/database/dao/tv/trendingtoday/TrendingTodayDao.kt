package com.cerminnovations.database.dao.tv.trendingtoday

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.database.entities.tv.trendingtoday.TrendingToday

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface TrendingTodayDao {
    @Query("SELECT * FROM trending_today_tv")
    fun getAll(): PagingSource<Int, TrendingToday>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrendingToday(series: List<TrendingToday>)

    @Query("DELETE FROM trending_today_tv")
    suspend fun deleteAll()
}
