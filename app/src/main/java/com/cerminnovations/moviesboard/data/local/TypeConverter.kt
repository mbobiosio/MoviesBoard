package com.cerminnovations.moviesboard.data.local

import androidx.room.TypeConverter
import com.cerminnovations.moviesboard.util.jsonToList
import com.cerminnovations.moviesboard.util.listToJson
import com.squareup.moshi.Moshi

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class TypeConverter {

    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun genreToString(genres: List<Int>): String =
        moshi.listToJson(genres)

    @TypeConverter
    fun stringToGenre(genres: String): List<Int>? =
        moshi.jsonToList(genres)
}
