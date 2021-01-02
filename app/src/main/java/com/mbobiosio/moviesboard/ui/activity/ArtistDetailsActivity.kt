package com.mbobiosio.moviesboard.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mbobiosio.moviesboard.R
import com.mbobiosio.moviesboard.databinding.ActivityArtistDetailsBinding
import com.mbobiosio.moviesboard.model.cast.MovieCast
import com.mbobiosio.moviesboard.model.cast.SeriesCast
import com.mbobiosio.moviesboard.util.IMDB_URL
import com.mbobiosio.moviesboard.util.asUri
import com.mbobiosio.moviesboard.util.navigateArtistCasts
import com.mbobiosio.moviesboard.util.openInBrowser
import com.mbobiosio.moviesboard.viewmodels.ArtistDetailViewModel

class ArtistDetailsActivity : AppCompatActivity(), (Any) -> Unit {
    private lateinit var binding: ActivityArtistDetailsBinding
    private val detailViewModel by viewModels<ArtistDetailViewModel>()
    private var imdbLink = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist_details)
        binding.lifecycleOwner = this

        val artistId = intent.getSerializableExtra("artist") as Int

        binding.toolbar.setNavigationOnClickListener { onBackPressed() }

        /*See all Artist Movies*/
        binding.textView20.setOnClickListener {
            navigateArtistCasts(this, artistId, "movies")
        }

        /*See all Artist Series*/
        binding.textView21.setOnClickListener {
            navigateArtistCasts(this, artistId, "series")
        }

        detailViewModel.artistProfile(artistId)

        detailViewModel.artist.observe(this) {
            it?.let {
                binding.artist = it
                imdbLink = it.imdbId!!
                binding.executePendingBindings()
            }
        }

        /*Go to IMDB Page*/
        binding.imdb.setOnClickListener {
            IMDB_URL.plus(imdbLink).asUri()?.openInBrowser(this)
        }
    }

    override fun invoke(any: Any) {
        when (any) {
            is MovieCast -> {
                navigateMovieDetails(any.id)
            }
            is SeriesCast -> {
                navigateSeriesDetails(any.id)
            }
        }
    }

    private fun navigateMovieDetails(id: Int) {
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra("movie", id)
        startActivity(intent)
    }

    private fun navigateSeriesDetails(id: Int) {
        val intent = Intent(this, SeriesDetailsActivity::class.java)
        intent.putExtra("series", id)
        startActivity(intent)
    }
}