package com.cerminnovations.moviesboard.data.local.dao.movies.nowplaying

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cerminnovations.moviesboard.data.local.entities.movies.nowplaying.NowPlayingRemoteKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Dao
interface NowPlayingMoviesRemoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKeys: List<NowPlayingRemoteKey>)

    @Query("SELECT * FROM now_playing_movie_remote_keys WHERE movieId =:id")
    suspend fun remoteKeyId(id: Long): NowPlayingRemoteKey?

    @Query("DELETE FROM now_playing_movie_remote_keys")
    suspend fun deleteAllKeys()
}
