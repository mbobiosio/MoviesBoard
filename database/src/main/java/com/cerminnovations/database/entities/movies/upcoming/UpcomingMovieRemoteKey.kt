package com.cerminnovations.database.entities.movies.upcoming

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Entity(tableName = "upcoming_movies_remote_keys")
data class UpcomingMovieRemoteKey(
    @PrimaryKey
    val movieId: Long,
    val prevKey: Int?,
    val nextKey: Int?
)
