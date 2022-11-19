package com.cerminnovations.moviesboard.presentation.moviedetail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.cerminnovations.core.base.BaseContract
import com.cerminnovations.core.base.BaseFragment
import com.cerminnovations.core.util.onError
import com.cerminnovations.core.util.onLoading
import com.cerminnovations.core.util.onSuccess
import com.cerminnovations.domain.listeners.CastItemClickListener
import com.cerminnovations.domain.model.cast.Cast
import com.cerminnovations.domain.model.movies.MovieDetail
import com.cerminnovations.moviesboard.R
import com.cerminnovations.moviesboard.databinding.FragmentMovieDetailBinding
import com.cerminnovations.moviesboard.presentation.adapter.CastsAdapter
import com.cerminnovations.moviesboard.presentation.adapter.PhotosAdapter
import com.cerminnovations.moviesboard.presentation.peopledetail.PeopleDetailFragmentArgs
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

            castsAdapter.castItemClickListener = object : CastItemClickListener {
                override fun onItemClick(castDetail: Cast?) {
                    castDetail?.let {
                        findNavController().navigate(
                            R.id.personDetailFragment,
                            PeopleDetailFragmentArgs(castDetail.id).toBundle()
                        )
                    }
                }
            }

            photos.apply {
                adapter = photosAdapter
            }

            veilLayout.veil()
/*
            videos.apply {
                adapter = videoAdapter
            }*/
        }

        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun getMovieDetails() {
        val movieItem = args.movieDetail
        viewModel.getMovieDetail(movieItem.movieId)
    }

    override fun observeData() {
        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            state onLoading {
            } onSuccess {
                updateUI(result)
            } onError {
                Timber.d("Error ${message?.errorMessage}")
            }
        }
    }

    private fun updateUI(movieDetail: MovieDetail?) = with(binding) {
        movieDetail?.let {
            movieDetailsLayout.apply {
                // movieCast.unVeil()
                veilLayout.unVeil()
                movie = it
            }
            handleVideo(it)
            castsAdapter.submitList(it.credits?.casts)
            photosAdapter.submitList(it.images?.posters)
            // videoAdapter.submitList(it.videoResponse?.results)
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

    override fun onDestroy() {
        binding.youTubePlayer.release()
        super.onDestroy()
    }
}
