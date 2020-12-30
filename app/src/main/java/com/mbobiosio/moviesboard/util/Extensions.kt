package com.mbobiosio.moviesboard.util

import android.annotation.SuppressLint
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
import kotlin.math.log10
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


@SuppressLint("SetTextI18n")
@BindingAdapter("prettyCount")
fun MaterialTextView.prettyCount(number: Number?) {

    val suffix = charArrayOf(' ', 'k', 'M', 'B', 'T', 'P', 'E')
    val numValue: Long = number!!.toLong()
    val value = floor(log10(numValue.toDouble())).toInt()
    val base = value / 3
    return if (value >= 3 && base < suffix.size) {
        this.text = DecimalFormat("#0.0").format(numValue / 10.0.pow((base * 3).toDouble())) + suffix[base].plus(" Votes")
    } else {
        this.text = DecimalFormat("#,##0").format(numValue).plus(" Votes")
    }
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

@BindingAdapter("revenue")
fun MaterialTextView.revenue(money: Long?) {
    if (money == null || money <= 0) {
        this.text = "-"
    } else {
        val numFormat = DecimalFormat("#,###,###")

        this.text = resources.getString(R.string.money_mask, numFormat.format(money))
    }
}

@BindingAdapter("budget")
fun MaterialTextView.budget(money: Int?) {
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