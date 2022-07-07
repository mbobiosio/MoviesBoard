package com.cerminnovations.database.util

import androidx.room.TypeConverter
import com.cerminnovations.core.util.jsonToList
import com.cerminnovations.core.util.listToJson
import com.squareup.moshi.Moshi

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class TypeConverter {

    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun intListToJson(genres: List<Int>): String =
        moshi.listToJson(genres)

    @TypeConverter
    fun jsonToIntList(genres: String): List<Int>? =
        moshi.jsonToList(genres)

    @TypeConverter
    fun stringListToJson(genres: List<String>): String =
        moshi.listToJson(genres)

    @TypeConverter
    fun jsonToStringList(genres: String): List<String>? =
        moshi.jsonToList(genres)
}
