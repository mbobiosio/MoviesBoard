package com.cerminnovations.core.util

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */

/**
 * [Moshi] extension to transform a [List] to Json
 * */
inline fun <reified T> Moshi.listToJson(data: List<T>): String =
    adapter<List<T>>(
        Types.newParameterizedType(
            List::class.java, T::class.java
        )
    ).toJson(data)

/**
 * [Moshi] extension to transform a json object to a [List]
 * */
inline fun <reified T> Moshi.jsonToList(json: String): List<T>? =
    adapter<List<T>>(
        Types.newParameterizedType(
            List::class.java, T::class.java
        )
    ).fromJson(json)
