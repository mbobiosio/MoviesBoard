package com.cerminnovations.moviesboard.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.cerminnovations.core.constant.Constants.IMDB_ARTIST_URL
import com.cerminnovations.moviesboard.R
import com.cerminnovations.moviesboard.data.remote.model.cast.MovieCastDto
import com.cerminnovations.moviesboard.data.remote.model.cast.SeriesCastDto
import com.cerminnovations.moviesboard.databinding.ActivityArtistDetailsBinding
import com.cerminnovations.moviesboard.util.asUri
import com.cerminnovations.moviesboard.util.navigateArtistCasts
import com.cerminnovations.moviesboard.util.openInBrowser
import com.cerminnovations.moviesboard.viewmodels.ArtistDetailViewModel

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
            IMDB_ARTIST_URL.plus(imdbLink).asUri()?.openInBrowser(this)
        }
    }

    override fun invoke(any: Any) {
        when (any) {
            is MovieCastDto -> {
                navigateMovieDetails(any.id!!)
            }
            is SeriesCastDto -> {
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
