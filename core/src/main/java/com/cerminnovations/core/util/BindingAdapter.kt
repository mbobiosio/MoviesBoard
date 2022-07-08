package com.cerminnovations.core.util

import android.annotation.SuppressLint
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.widget.ContentLoadingProgressBar
import androidx.databinding.BindingAdapter
import coil.load
import com.cerminnovations.core.R
import com.cerminnovations.core.constant.Constants.BACKDROP_SIZE_780
import com.cerminnovations.core.constant.Constants.POSTER_SIZE_500
import com.cerminnovations.core.constant.Constants.PROFILE_SIZE_185
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
import java.text.DecimalFormat
import java.util.*
import kotlin.math.floor

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@BindingAdapter("setImage")
fun AppCompatImageView.setImage(url: String) {
    load(url) {
        crossfade(true)
        placeholder(R.drawable.loading_animation)
    }
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

@BindingAdapter("creditPoster")
fun ShapeableImageView.creditPoster(url: String?) {
    url?.let {
        setImage(POSTER_SIZE_500.plus(it))
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
        text = formatVotesCount(number)
    }
}

@BindingAdapter("formatDate")
fun MaterialTextView.formatDate(date: String?) {
    date?.let {
        this.text = formatReadableDate(it)
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

@BindingAdapter("showWhen")
fun ContentLoadingProgressBar.showWhen(condition: Boolean) {
    if (condition) show() else hide()
}
