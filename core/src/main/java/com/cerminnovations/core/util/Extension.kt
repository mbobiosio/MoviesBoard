package com.cerminnovations.core.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.text.DecimalFormat
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

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

fun <T> LiveData<T>.observeOnce(lifecycleOwner: LifecycleOwner, observer: Observer<T>) {
    observe(
        lifecycleOwner,
        object : Observer<T> {
            override fun onChanged(t: T) {
                observer.onChanged(t)
                removeObserver(this)
            }
        }
    )
}

fun roundUpNumber(number: Double): String =
    "%.1f".format(number)

fun formatVotesCount(count: Number): String {
    val suffix = charArrayOf(' ', 'k', 'M', 'B', 'T', 'P', 'E')
    val value = floor(log10(count.toDouble())).toInt()
    val base = value / 3

    val voteCount = when {
        value >= 3 && base < suffix.size -> {
            val calValue = count.toLong() / 10.0.pow(base * 3)
            DecimalFormat("#0.0").format(calValue) + suffix[base]
        }
        else -> {
            DecimalFormat("#0").format(count.toLong())
        }
    }
    return voteCount
}
