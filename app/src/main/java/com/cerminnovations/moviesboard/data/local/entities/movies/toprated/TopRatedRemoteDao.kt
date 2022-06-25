package com.cerminnovations.moviesboard.data.local.entities.movies.toprated

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Entity(tableName = "top_rated_movie_remote_keys")
data class TopRatedRemoteDao(
    @PrimaryKey
    val movieId: Long,
    val prevKey: Int?,
    val nextKey: Int?
)
