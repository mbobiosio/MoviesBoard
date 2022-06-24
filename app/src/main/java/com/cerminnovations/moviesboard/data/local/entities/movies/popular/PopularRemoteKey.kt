package com.cerminnovations.moviesboard.data.local.entities.movies.popular

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Entity(tableName = "popular_movie_remote_keys")
data class PopularRemoteKey(
    @PrimaryKey
    val movieId: Long,
    val prevKey: Int?,
    val nextKey: Int?
)
