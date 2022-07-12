package com.cerminnovations.moviesboard.presentation.seriesdetail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.cerminnovations.core.base.BaseContract
import com.cerminnovations.core.base.BaseFragment
import com.cerminnovations.domain.model.series.TvSeriesInfo
import com.cerminnovations.domain.uistate.tv.TvUiState
import com.cerminnovations.moviesboard.databinding.FragmentSeriesDetailsBinding
import com.cerminnovations.moviesboard.presentation.adapter.CastsAdapter
import com.cerminnovations.moviesboard.presentation.adapter.PhotosAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@AndroidEntryPoint
class SeriesDetailFragment :
    BaseFragment<FragmentSeriesDetailsBinding>(
        FragmentSeriesDetailsBinding::inflate
    ),
    BaseContract {

    private val args: SeriesDetailFragmentArgs by navArgs()

    private val viewModel by viewModels<SeriesDetailViewModel>()

    private val photosAdapter by lazy {
        PhotosAdapter()
    }

    private val castAdapter by lazy {
        CastsAdapter()
    }

    override fun setupViews() {
        initViews()

        initTvData()

        observeData()
    }

    private fun initViews() = with(binding) {
        viewLifecycleOwner.lifecycle.addObserver(youTubePlayer)

        seriesDetailsLayout.apply {
            photos.apply {
                adapter = photosAdapter
            }

            movieCast.apply {
                adapter = castAdapter
            }
        }
    }

    private fun initTvData() {
        val tvItem = args.seriesDetail
        tvItem?.let {
            Timber.d("${it.tvId}")
            viewModel.getTvDetails(tvId = it.tvId)
        }
    }

    override fun observeData() {

        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                is TvUiState.Loading -> {
                    showProgress(true)
                }

                is TvUiState.Success -> {
                    showProgress(false)
                    updateUi(it.result)
                }

                is TvUiState.Error -> {
                    showProgress(false)
                    showError(true, it.message?.errorMessage)
                }
            }
        }
    }

    private fun updateUi(series: TvSeriesInfo) = with(binding) {
        seriesDetailsLayout.seriesDetail = series
        photosAdapter.submitList(series.images?.backdrops)
        castAdapter.submitList(series.credits?.casts)
    }

    override fun showProgress(isVisible: Boolean) {
    }

    override fun showError(isError: Boolean, error: String?) {
        Timber.d("Error $error")
    }

    override fun onDestroy() {
        binding.youTubePlayer.release()
        super.onDestroy()
    }
}
