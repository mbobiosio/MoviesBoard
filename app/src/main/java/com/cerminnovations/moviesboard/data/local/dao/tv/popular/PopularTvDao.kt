package com.cerminnovations.moviesboard.data.local.dao.tv.popular

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.moviesboard.data.local.entities.tv.popular.PopularTv

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface PopularTvDao {

    @Query("SELECT * FROM popular_tv")
    fun getAll(): PagingSource<Int, PopularTv>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvSeries(series: List<PopularTv>)

    @Query("DELETE FROM popular_tv")
    suspend fun deleteAll()
}
