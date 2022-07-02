package com.cerminnovations.moviesboard.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.cerminnovations.moviesboard.R
import com.cerminnovations.moviesboard.data.remote.model.cast.CastDto
import com.cerminnovations.moviesboard.databinding.ActivityMovieDetailBinding
import com.cerminnovations.moviesboard.ui.adapter.CastsAdapter
import com.cerminnovations.moviesboard.util.navigateArtistDetails
import com.cerminnovations.moviesboard.viewmodels.MovieDetailViewModel

class MovieDetailActivity : AppCompatActivity(), (CastDto) -> Unit {

    private val viewModel by viewModels<MovieDetailViewModel>()
    private lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail)
        binding.lifecycleOwner = this

        val movieId = intent.getSerializableExtra("movie") as Int

        // lifecycle.addObserver(binding.youTubePlayerView)

        binding.toolbar.setNavigationOnClickListener { onBackPressed() }

        val castsAdapter = CastsAdapter(this)
        binding.movieCast.adapter = castsAdapter

        viewModel.getMovieDetails(movieId).observe(this) {
            it?.let {
                binding.movie = it

                // castsAdapter.submitList(it.credits.casts)
                // binding.genre.text = getGenre(it.genres)
/*
                it.videoResponse.results.forEach { video ->
                    when (video.name) {
                        "Official Main Trailer" -> {
                            handlePlayer(video.key)
                        }
                        else -> {
                            handlePlayer(video.key)
                        }
                    }
                }
 */
            }
        }
    }

    private fun handlePlayer(key: String) {
    }

    override fun invoke(cast: CastDto) {
        navigateArtistDetails(this, cast.id)
    }
}
