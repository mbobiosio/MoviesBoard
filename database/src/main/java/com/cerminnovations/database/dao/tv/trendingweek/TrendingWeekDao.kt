package com.cerminnovations.database.dao.tv.trendingweek

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.database.entities.tv.trendingweek.TrendingWeek

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface TrendingWeekDao {

    @Query("SELECT * FROM trending_week_tv")
    fun getAll(): PagingSource<Int, TrendingWeek>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrendingWeek(series: List<TrendingWeek>)

    @Query("DELETE FROM trending_week_tv")
    suspend fun deleteAll()
}
