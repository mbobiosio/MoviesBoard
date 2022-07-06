package com.cerminnovations.core.constant

import androidx.fragment.app.Fragment
import com.cerminnovations.core.R
import com.cerminnovations.core.model.Category

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
object Constants {

    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val apiKey = "1238d2a97622a6767443621fe24e29eb"
    const val IMDB_ARTIST_URL = "https://imdb.com/name/"

    private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/"
    const val BACKDROP_SIZE_780 = IMAGE_BASE_URL + "w780"
    const val POSTER_SIZE_500 = IMAGE_BASE_URL + "w500"
    const val PROFILE_SIZE_185 = IMAGE_BASE_URL + "w185"

    const val DEFAULT_PAGE_INDEX = 1
    const val DEFAULT_PAGE_SIZE = 20

    fun Fragment.movieCategories() = arrayListOf<Category>().apply {
        add(Category(getString(R.string.popular)))
        add(Category(getString(R.string.top_rated)))
        add(Category(getString(R.string.upcoming)))
        add(Category(getString(R.string.now_playing)))
        add(Category(getString(R.string.trending)))
    }

    fun Fragment.seriesCategories() = arrayListOf<Category>().apply {
        add(Category(getString(R.string.popular)))
        add(Category(getString(R.string.top_rated)))
        add(Category(getString(R.string.now_showing)))
        add(Category(getString(R.string.showing_today)))
        add(Category(getString(R.string.trending_today)))
        add(Category(getString(R.string.trending_this_week)))
    }
}
