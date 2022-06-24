package com.cerminnovations.moviesboard.util

import androidx.fragment.app.Fragment
import com.cerminnovations.moviesboard.BuildConfig
import com.cerminnovations.moviesboard.R

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
object Constants {

    const val BASE_URL = BuildConfig.BASE_URL
    const val apiKey = BuildConfig.API_KEY

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
