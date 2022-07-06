package com.cerminnovations.moviesboard.presentation.moviedetail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.cerminnovations.core.base.BaseContract
import com.cerminnovations.core.base.BaseFragment
import com.cerminnovations.domain.model.movies.MovieDetail
import com.cerminnovations.domain.uistate.UIState
import com.cerminnovations.moviesboard.databinding.FragmentMovieDetailBinding
import com.cerminnovations.moviesboard.presentation.adapter.CastsAdapter
import com.cerminnovations.moviesboard.presentation.adapter.PhotosAdapter
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@AndroidEntryPoint
class MovieDetailFragment :
    BaseFragment<FragmentMovieDetailBinding>(
        FragmentMovieDetailBinding::inflate
    ),
    BaseContract {

    private val viewModel by viewModels<MovieDetailViewModel>()

    private val args: MovieDetailFragmentArgs by navArgs()

    private val castsAdapter by lazy {
        CastsAdapter()
    }

    private val photosAdapter by lazy {
        PhotosAdapter()
    }

    override fun setupViews() {
        initViews()

        observeData()

        getMovieDetails()
    }

    private fun initViews() = with(binding) {
        viewLifecycleOwner.lifecycle.addObserver(youTubePlayer)

        movieDetailsLayout.apply {
            movieCast.apply {
                adapter = castsAdapter
            }

            photos.apply {
                adapter = photosAdapter
            }
        }

        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun getMovieDetails() {
        val movieItem = args.movieDetail
        viewModel.getMovieDetail(movieItem.movieId)
        Timber.d("${args.movieDetail.movieId}")
    }

    override fun observeData() {
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                is UIState.Loading -> {
                }
                is UIState.Success -> {
                    updateUI(it.result)
                }
                is UIState.Error -> {
                    Timber.d("Error ${it.message?.errorMessage}")
                }
            }
        }
    }

    private fun updateUI(movieDetail: MovieDetail?) = with(binding) {
        movieDetail?.let {
            movieDetailsLayout.movie = it
            handleVideo(it)
            castsAdapter.submitList(it.credits?.casts)
            photosAdapter.submitList(it.images?.posters)
        }
    }

    private fun handleVideo(movieDetail: MovieDetail?) {
        movieDetail?.let {
            it.videoResponse?.results?.forEach { video ->
                handleYoutubePlayer(video.key)
            }
        }
    }

    private fun handleYoutubePlayer(key: String) = with(binding) {
        youTubePlayer.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)
                youTubePlayer.cueVideo(key, 0f)
            }
        })
    }

    override fun showProgress(isVisible: Boolean) {
    }

    override fun showError(isError: Boolean, error: String?) {
    }
}
