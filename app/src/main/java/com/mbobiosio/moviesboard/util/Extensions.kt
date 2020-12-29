package com.mbobiosio.moviesboard.util

import android.text.format.DateUtils
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.google.android.material.textview.MaterialTextView
import com.mbobiosio.moviesboard.R
import com.mbobiosio.moviesboard.model.production.ProductionCompany
import com.mbobiosio.moviesboard.model.production.ProductionCountry
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.floor
import kotlin.math.ln
import kotlin.math.pow

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

@BindingAdapter("prettyCount")
fun prettyCount(view: View, count: Long): String {
        if (count < 1000) return "" + count
        val exp = (ln(count.toDouble()) / ln(1000.0)).toInt()
        return String.format("%.1f %c", count / 1000.0.pow(exp.toDouble()), "kMGTPE"[exp - 1])
}

@BindingAdapter("bindRuntime")
fun MaterialTextView.bindRuntime(minute: Int?) {
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

@BindingAdapter("bindTvRuntime")
fun MaterialTextView.bindTvRuntime(list: List<Int>?) {
    if (list == null || list.isEmpty()) {
        this.text = "-"
    } else {
        val stringBuilder = StringBuilder()
        list.forEachIndexed { index, i ->
            stringBuilder.append(i).append(" m")
            if (index != list.lastIndex) {
                stringBuilder.append(", ")
            }
        }

        this.text = stringBuilder.toString()
    }
}

@BindingAdapter("bindRevenue")
fun MaterialTextView.bindRevenue(money: Long?) {
    if (money == null || money <= 0) {
        this.text = "-"
    } else {
        val numFormat = DecimalFormat("#,###,###")

        this.text = resources.getString(R.string.money_mask, numFormat.format(money))
    }
}

@BindingAdapter("bindProductionCompany")
fun MaterialTextView.bindProductionCompany(list: List<ProductionCompany>?) {
    if (list == null || list.isEmpty()) {
        this.text = "-"
    } else {
        val stringBuilder = StringBuilder()
        list.forEachIndexed { index, p ->
            stringBuilder.append(p.name)
            if (index != list.lastIndex) {
                stringBuilder.appendLine()
            }
        }
        this.text = stringBuilder.toString()
    }
}

@BindingAdapter("bindProductionCountry")
fun MaterialTextView.bindProductionCountry(list: List<ProductionCountry>?) {
    if (list == null || list.isEmpty()) {
        this.text = "-"
    } else {
        val stringBuilder = StringBuilder()
        list.forEachIndexed { index, p ->
            stringBuilder.append(p.name)
            if (index != list.lastIndex) {
                stringBuilder.appendLine()
            }
        }
        this.text = stringBuilder.toString()
    }
}