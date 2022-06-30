package com.cerminnovations.core.constant

import androidx.fragment.app.Fragment
import com.cerminnovations.core.R

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
object Constants {

    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val apiKey = "1238d2a97622a6767443621fe24e29eb"

    const val DEFAULT_PAGE_INDEX = 1
    const val DEFAULT_PAGE_SIZE = 40

    fun Fragment.movieCategories() = arrayListOf<String>().apply {
        add(getString(R.string.popular))
        add(getString(R.string.top_rated))
        add(getString(R.string.upcoming))
        add(getString(R.string.now_playing))
        add(getString(R.string.trending))
    }

    fun Fragment.seriesCategories() = arrayListOf<String>().apply {
        add(getString(R.string.popular))
        add(getString(R.string.top_rated))
        add(getString(R.string.now_showing))
        add(getString(R.string.showing_today))
        add(getString(R.string.trending_today))
        add(getString(R.string.trending_this_week))
    }
}
