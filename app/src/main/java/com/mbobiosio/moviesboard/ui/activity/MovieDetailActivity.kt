package com.mbobiosio.moviesboard.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mbobiosio.moviesboard.R
import com.mbobiosio.moviesboard.databinding.ActivityMovieDetailBinding
import com.mbobiosio.moviesboard.viewmodels.MovieDetailViewModel
import timber.log.Timber

class MovieDetailActivity : AppCompatActivity() {

    private val viewModel by viewModels<MovieDetailViewModel>()

    private lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail)
        binding.lifecycleOwner = this

        val movieId = intent.getSerializableExtra("movie") as Int
        Timber.d("$movieId")

        /*lifecycleScope.launch {
            viewModel.getMovieDetails(movieId).observe(this@MovieDetailActivity) {
                it?.let {
                    binding.movie = it
                    Timber.d("${it.title}")
                }
            }
        }*/

        viewModel.getMovieDetails(movieId).observe(this) {

            it?.let {
                binding.movie = it

                for (i in it.videoResponse.results.indices) {
                    val video = it.videoResponse.results[i]
                    when {
                        video.name.contains("Official Main Trailer", ignoreCase = true) -> {
                            Timber.d(video.name)
                        }
                        else -> {
                            Timber.d(video.name)
                        }
                    }
                }

            }
        }
    }

}