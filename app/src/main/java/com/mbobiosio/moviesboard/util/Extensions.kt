package com.mbobiosio.moviesboard.util

import android.text.format.DateUtils
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*


@BindingAdapter("releaseDate")
fun releaseDate(view: View, text: String?) {
    (view as AppCompatTextView).text = if (text == null || text.isEmpty()) {
        "Not yet Released"
    } else {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = simpleDateFormat.parse(text)
        DateUtils.getRelativeTimeSpanString(date?.time ?: 0).toString()
    }
}
