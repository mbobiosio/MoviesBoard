package com.mbobiosio.moviesboard.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.mbobiosio.moviesboard.R
import com.mbobiosio.moviesboard.databinding.ActivityArtistCastsBinding
import com.mbobiosio.moviesboard.model.artists.ArtistInfo
import com.mbobiosio.moviesboard.ui.adapter.ArtistMoviesAdapter
import com.mbobiosio.moviesboard.ui.adapter.ArtistSeriesAdapter
import com.mbobiosio.moviesboard.viewmodels.ArtistDetailViewModel
import timber.log.Timber

class ArtistCastsActivity : AppCompatActivity(), (Any) -> Unit {
    private lateinit var binding: ActivityArtistCastsBinding
    private val viewModel by viewModels<ArtistDetailViewModel>()
    private lateinit var artistMoviesAdapter: ArtistMoviesAdapter
    private lateinit var artistSeriesAdapter: ArtistSeriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist_casts)
        binding.lifecycleOwner = this

        val artistId = intent.getSerializableExtra("artist") as Int
        val castType = intent.getSerializableExtra("type")

        viewModel.artistProfile(artistId)

        binding.toolbar.setNavigationOnClickListener { onBackPressed() }

        /*Set Movies Adapter*/
        artistMoviesAdapter = ArtistMoviesAdapter(this)
        artistSeriesAdapter = ArtistSeriesAdapter(this)

        viewModel.artist.observe(this) {
            it?.let {
                when (castType) {
                    "movies" -> movies(it)
                    "series" -> series(it)
                }
            }
        }
    }

    private fun movies(artistInfo: ArtistInfo) {
        binding.toolbar.title = getString(R.string.movie_casts)
        binding.artistCasts.apply {
            this.adapter = artistMoviesAdapter
            layoutManager = GridLayoutManager(this@ArtistCastsActivity, 3)
        }
        artistMoviesAdapter.submitList(artistInfo.movieCredits.cast)
    }

    private fun series(artistInfo: ArtistInfo) {
        binding.toolbar.title = getString(R.string.series_casts)
        binding.artistCasts.apply {
            this.adapter = artistSeriesAdapter
            layoutManager = GridLayoutManager(this@ArtistCastsActivity, 3)
        }
        artistSeriesAdapter.submitList(artistInfo.seriesCredits.cast)
    }

    override fun invoke(any: Any) {
        Timber.d("$any")
    }
}