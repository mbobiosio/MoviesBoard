package com.cerminnovations.moviesboard.util

import android.annotation.SuppressLint
import android.text.format.DateUtils
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.cerminnovations.moviesboard.R
import com.cerminnovations.moviesboard.model.Genre
import com.cerminnovations.moviesboard.service.MovieType
import com.cerminnovations.moviesboard.service.SeriesType
import com.google.android.material.textview.MaterialTextView
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

val DEFAULT_MOVIES_TYPE = MovieType.POPULAR
val DEFAULT_SERIES_TYPE = SeriesType.POPULAR
const val IMDB_URL = "https://imdb.com/name/"

@BindingAdapter("releaseDate")
fun releaseDate(view: View, date: String?) {
    (view as AppCompatTextView).text = if (date == null || date.isEmpty()) {
        ""
    } else {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val formatDate = simpleDateFormat.parse(date)
        DateUtils.getRelativeTimeSpanString(formatDate?.time ?: 0).toString()
    }
}

@BindingAdapter("date")
fun date(view: View, date: String?) {
    (view as AppCompatTextView).text = if (date == null || date.isEmpty()) {
        ""
    } else {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val formatDate = simpleDateFormat.parse(date)
        DateUtils.getRelativeTimeSpanString(formatDate?.time ?: 0).toString()
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("voteCount")
fun MaterialTextView.voteCount(number: Number?) {
    if (number == null) {
        this.text = ""
    } else {
        val suffix = charArrayOf(' ', 'k', 'M', 'B', 'T', 'P', 'E')
        val numValue: Long = number.toLong()
        val value = floor(log10(numValue.toDouble())).toInt()
        val base = value / 3
        return if (value >= 3 && base < suffix.size) {
            this.text =
                DecimalFormat("#0.0").format(numValue / 10.0.pow((base * 3).toDouble())) + suffix[base].plus(
                " Votes"
            )
        } else {
            this.text = DecimalFormat("#,##0").format(numValue).plus(" Votes")
        }
    }
}

@BindingAdapter("runtime")
fun MaterialTextView.runtime(minute: Int?) {
    if (minute == null || minute <= 0) {
        this.text = "-"
    } else {
        val hours = floor(minute / 60.0).toInt()
        val stringHours =
            resources.getQuantityString(R.plurals.hours, hours, hours)

        val minutes = minute % 60
        val stringMinutes =
            resources.getQuantityString(R.plurals.minutes, minutes, minutes)
        this.text = resources.getString(
            R.string.runtime_mask,
            stringHours,
            stringMinutes
        )
    }
}

@BindingAdapter("seriesRuntime")
fun MaterialTextView.seriesRuntime(list: List<Int>?) {
    if (list == null || list.isEmpty()) {
        this.text = "-"
    } else {
        val stringBuilder = StringBuilder()
        list.forEachIndexed { index, i ->
            stringBuilder.append(i).append("m")
            if (index != list.lastIndex) {
                stringBuilder.append(", ")
            }
        }
        this.text = stringBuilder.toString()
    }
}

@BindingAdapter("castCount")
fun MaterialTextView.castCount(series: List<Any>?) {
    if (series == null || series.isEmpty()) {
        this.text = "?"
    } else {
        this.text = series.size.toString()
    }
}

@BindingAdapter("revenue")
fun MaterialTextView.revenue(amount: Long?) {
    if (amount == null || amount <= 0) {
        this.text = "-"
    } else {
        val revenueFormat = DecimalFormat("#,###,###")
        this.text = resources.getString(R.string.revenue_amount, revenueFormat.format(amount))
    }
}

@BindingAdapter("budget")
fun MaterialTextView.budget(amount: Int?) {
    if (amount == null || amount <= 0) {
        this.text = "-"
    } else {
        val amountFormat = DecimalFormat("#,###,###")
        this.text = resources.getString(R.string.revenue_amount, amountFormat.format(amount))
    }
}

fun getGenre(ids: List<Genre>): String {
    var genre = ""
    ids.forEach {
        when (it.id) {
            28 -> genre += "Action | "
            12 -> genre += "Adventure | "
            16 -> genre += "Animation | "
            35 -> genre += "Comedy | "
            80 -> genre += "Crime | "
            99 -> genre += "Documentary | "
            18 -> genre += "Drama |"
            10751 -> genre += "Family | "
            14 -> genre += "Fantasy | "
            36 -> genre += "History | "
            27 -> genre += "Horror | "
            10402 -> genre += "Music | "
            9648 -> genre += "Mystery | "
            10749 -> genre += "Romance | "
            878 -> genre += "Science Fiction | "
            10770 -> genre += "TV Movie | "
            53 -> genre += "Thriller | "
            10752 -> genre += "War | "
            37 -> genre += "Western | "
            else -> genre += "Unresolved symbol"
        }
    }
    when {
        genre != "" -> genre = genre.substring(0, genre.length - 2)
    }

    return genre
}

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
