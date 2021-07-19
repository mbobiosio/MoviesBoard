package com.cerminnovations.moviesboard.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat
import com.cerminnovations.moviesboard.ui.activity.*

fun Uri?.openInBrowser(context: Context) {
    this?: return

    val intent = Intent(Intent.ACTION_VIEW, this)
    ContextCompat.startActivity(context, intent, null)
}

fun String?.asUri(): Uri? {
    try {
        return Uri.parse(this)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return null
}

fun navigateArtistCasts(context: Context?, artistId: Int?, type: String?) {
    val intent = Intent(context, ArtistCastsActivity::class.java)
    intent.putExtra("artist", artistId)
    intent.putExtra("type", type)
    context?.startActivity(intent)
}

fun navigateSeriesDetails(context: Context?, series: Int?) {
    val intent = Intent(context, SeriesDetailsActivity::class.java)
    intent.putExtra("series", series)
    context?.startActivity(intent)
}

fun navigateMovieDetails(context: Context?, movie: Int?) {
    val intent = Intent(context, MovieDetailActivity::class.java)
    intent.putExtra("movie", movie)
    context?.startActivity(intent)
}

fun navigateSearch(context: Context?) {
    val intent = Intent(context, SearchActivity::class.java)
    context?.startActivity(intent)
}

fun navigateArtistDetails(context: Context?, id: Int?) {
    val intent = Intent(context, ArtistDetailsActivity::class.java)
    intent.putExtra("artist", id)
    context?.startActivity(intent)
}