package com.mbobiosio.moviesboard.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat
import com.mbobiosio.moviesboard.ui.activity.ArtistCastsActivity

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