package com.cerminnovations.core.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.DateTimeException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.format.FormatStyle

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */

@RequiresApi(Build.VERSION_CODES.O)
fun parseIsoDate(date: String?): LocalDate? {
    return try {
        date?.let { LocalDate.parse(it, DateTimeFormatter.ISO_LOCAL_DATE) }
    } catch (e: DateTimeParseException) {
        e.printStackTrace()
        null
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun formatDate(
    date: LocalDate,
    formatter: DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE
): String? {
    return try {
        date.format(formatter)
    } catch (e: DateTimeException) {
        e.printStackTrace()
        null
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun LocalDate.formatLocally(formatStyle: FormatStyle = FormatStyle.MEDIUM): String? {
    return formatDate(this, DateTimeFormatter.ofLocalizedDate(formatStyle))
}