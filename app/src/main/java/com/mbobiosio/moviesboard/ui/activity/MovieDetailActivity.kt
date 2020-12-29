package com.mbobiosio.moviesboard.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.mbobiosio.moviesboard.R
import com.mbobiosio.moviesboard.databinding.ActivityMovieDetailBinding
import com.mbobiosio.moviesboard.viewmodels.MovieDetailViewModel
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import timber.log.Timber


class MovieDetailActivity : AppCompatActivity() {

    private val viewModel by viewModels<MovieDetailViewModel>()
    private lateinit var youTubePlayer: YouTubePlayerView
    private lateinit var binding: ActivityMovieDetailBinding
    private lateinit var youtubeKey : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail)
        binding.lifecycleOwner = this

        val movieId = intent.getSerializableExtra("movie") as Int

        lifecycle.addObserver(binding.youTubePlayerView)

        viewModel.getMovieDetails(movieId).observe(this) {

            it?.let {
                binding.movie = it

                for (i in it.videoResponse.results.indices) {
                    val video = it.videoResponse.results[i]
                    when {
                        video.name.contains("Official Main Trailer", ignoreCase = true) -> {
                            youtubeKey = video.key
                            Timber.d("Key $youtubeKey")
                            handlePlayer(youtubeKey)
                        }
                        else -> {
                            youtubeKey = video.key
                            Timber.d("Key $youtubeKey")
                            handlePlayer(youtubeKey)
                        }
                    }
                }

            }
        }


    }




    private fun handlePlayer(key: String) {

        binding.youTubePlayerView.addYouTubePlayerListener(object :
            AbstractYouTubePlayerListener() {

            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)
                youTubePlayer.cueVideo(key, 0f)
                Timber.d("Player Key $key")
            }
        })
    }


}