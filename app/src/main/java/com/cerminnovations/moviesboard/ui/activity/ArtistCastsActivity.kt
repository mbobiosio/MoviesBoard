package com.cerminnovations.moviesboard.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.cerminnovations.moviesboard.R
import com.cerminnovations.moviesboard.data.remote.model.artists.ArtistInfo
import com.cerminnovations.moviesboard.data.remote.model.cast.MovieCastDto
import com.cerminnovations.moviesboard.data.remote.model.cast.SeriesCastDto
import com.cerminnovations.moviesboard.databinding.ActivityArtistCastsBinding
import com.cerminnovations.moviesboard.ui.adapter.ArtistMoviesAdapter
import com.cerminnovations.moviesboard.ui.adapter.ArtistSeriesAdapter

class ArtistCastsActivity : AppCompatActivity(), (Any) -> Unit {
    private lateinit var binding: ActivityArtistCastsBinding
    private lateinit var artistMoviesAdapter: ArtistMoviesAdapter
    private lateinit var artistSeriesAdapter: ArtistSeriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist_casts)
        binding.lifecycleOwner = this

        val artistId = intent.getSerializableExtra("artist") as Int
        val castType = intent.getSerializableExtra("type")

        // viewModel.artistProfile(artistId)

        binding.toolbar.setNavigationOnClickListener { onBackPressed() }

        /*Set Movies Adapter*/
        artistMoviesAdapter = ArtistMoviesAdapter(this)

        /*Set Series Adapter*/
        artistSeriesAdapter = ArtistSeriesAdapter(this)
/*
        viewModel.artist.observe(this) {
            it?.let {
                when (castType) {
                    "movies" -> movies(it)
                    "series" -> series(it)
                }
            }
        }
   */
    }

    private fun movies(artistInfo: ArtistInfo) {
        // binding.toolbar.title = getString(R.string.movie_casts)
        binding.artistCasts.apply {
            this.adapter = artistMoviesAdapter
            layoutManager = GridLayoutManager(this@ArtistCastsActivity, 3)
        }
        artistMoviesAdapter.submitList(artistInfo.movieCredits!!.cast)
    }

    private fun series(artistInfo: ArtistInfo) {
        // binding.toolbar.title = getString(R.string.series_casts)
        binding.artistCasts.apply {
            this.adapter = artistSeriesAdapter
            layoutManager = GridLayoutManager(this@ArtistCastsActivity, 3)
        }
        artistSeriesAdapter.submitList(artistInfo.seriesCredits!!.cast)
    }

    override fun invoke(any: Any) {
        when (any) {
            is SeriesCastDto -> {
                // navigateSeriesDetails(this, any.id)
            }
            is MovieCastDto -> {
                // navigateMovieDetails(this, any.id)
            }
        }
    }
}
