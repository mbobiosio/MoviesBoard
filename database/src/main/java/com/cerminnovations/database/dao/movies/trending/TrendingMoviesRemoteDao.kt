package com.cerminnovations.database.dao.movies.trending

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.database.entities.movies.trending.TrendingMoviesRemoteKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface TrendingMoviesRemoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKeys: List<TrendingMoviesRemoteKey>)

    @Query("SELECT * FROM trending_movies_remote_keys WHERE movieId = :id")
    suspend fun remoteKeyId(id: Long): TrendingMoviesRemoteKey?

    @Query("DELETE FROM trending_movies_remote_keys")
    suspend fun deleteAllKeys()
}
