package com.cerminnovations.database.entities.movies.nowplaying

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Entity(tableName = "now_playing_movie_remote_keys")
data class NowPlayingRemoteKey(
    @PrimaryKey
    val movieId: Long,
    val prevKey: Int?,
    val nextKey: Int?
)
