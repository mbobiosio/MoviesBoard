package com.mbobiosio.moviesboard.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mbobiosio.moviesboard.R
import com.mbobiosio.moviesboard.databinding.ActivityArtistDetailsBinding
import com.mbobiosio.moviesboard.model.cast.MovieCast
import com.mbobiosio.moviesboard.model.cast.SeriesCast
import com.mbobiosio.moviesboard.ui.adapter.ArtistMoviesAdapter
import com.mbobiosio.moviesboard.ui.adapter.ArtistSeriesAdapter
import com.mbobiosio.moviesboard.viewmodels.ArtistDetailViewModel

class ArtistDetailsActivity : AppCompatActivity(), (Any) -> Unit {
    private lateinit var binding: ActivityArtistDetailsBinding
    private val detailViewModel by viewModels<ArtistDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist_details)
        binding.lifecycleOwner = this

        val artistId = intent.getSerializableExtra("artist") as Int

        val artistMovies = ArtistMoviesAdapter(this)
        val artistSeries = ArtistSeriesAdapter(this)

        binding.toolbar.setNavigationOnClickListener { onBackPressed() }

        binding.artistMovies.apply {
            this.adapter = artistMovies
            layoutManager = LinearLayoutManager(this@ArtistDetailsActivity, RecyclerView.HORIZONTAL, false)
        }

        binding.artistSeries.apply {
            this.adapter = artistSeries
            layoutManager = LinearLayoutManager(this@ArtistDetailsActivity, RecyclerView.HORIZONTAL, false)
        }

        detailViewModel.artistProfile(artistId)

        detailViewModel.artist.observe(this) {
            it?.let {
                binding.artist = it
                artistMovies.submitList(it.movieCredits.cast)
                artistSeries.submitList(it.seriesCredits.cast)
                binding.executePendingBindings()
            }
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