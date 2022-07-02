package com.cerminnovations.core.util

import android.annotation.SuppressLint
import android.text.format.DateUtils
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import coil.load
import com.cerminnovations.core.R
import com.google.android.material.textview.MaterialTextView
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/"
const val BACKDROP_SIZE_780 = IMAGE_BASE_URL + "w780"
const val PROFILE_SIZE_185 = IMAGE_BASE_URL + "w185"

@BindingAdapter("setImage")
fun AppCompatImageView.setImage(url: String) {
    load(url)
}

@BindingAdapter("backdropImage")
fun AppCompatImageView.backdropImage(url: String?) {
    url?.let {
        setImage(BACKDROP_SIZE_780.plus(it))
    }
}

@BindingAdapter("moviePoster")
fun AppCompatImageView.moviePoster(url: String?) {
    url?.let {
        setImage(BACKDROP_SIZE_780.plus(it))
    }
}

@BindingAdapter("castImage")
fun AppCompatImageView.castImage(imagePath: String?) {
    imagePath?.let {
        setImage(PROFILE_SIZE_185.plus(it))
    }
}

@BindingAdapter("voteAverage")
fun MaterialTextView.voteAverage(number: Double?) {
    number?.let {
        text = roundUpNumber(it)
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
