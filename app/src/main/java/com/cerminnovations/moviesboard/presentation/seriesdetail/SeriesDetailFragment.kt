package com.cerminnovations.moviesboard.presentation.seriesdetail

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
import com.cerminnovations.domain.model.series.TvSeriesInfo
import com.cerminnovations.moviesboard.R
import com.cerminnovations.moviesboard.databinding.FragmentSeriesDetailsBinding
import com.cerminnovations.moviesboard.presentation.adapter.CastsAdapter
import com.cerminnovations.moviesboard.presentation.adapter.PhotosAdapter
import com.cerminnovations.moviesboard.presentation.peopledetail.PeopleDetailFragmentArgs
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
            veilLayout.veil()
            photos.apply {
                adapter = photosAdapter
            }

            movieCast.apply {
                adapter = castAdapter
            }
            castAdapter.castItemClickListener = object : CastItemClickListener {
                override fun onItemClick(castDetail: Cast?) {
                    castDetail?.let {
                        findNavController().navigate(
                            R.id.personDetailFragment,
                            PeopleDetailFragmentArgs(castDetail.id).toBundle()
                        )
                    }
                }
            }
        }

        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
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
        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            state onLoading {
                // update progress indicator
                showProgress(true)
            } onSuccess {
                showProgress(false)
                // update ui
                updateUi(result)
            } onError {
                showProgress(false)
                // show error
                showError(true, message?.errorMessage)
            }
        }
    }

    private fun updateUi(series: TvSeriesInfo) = with(binding) {
        seriesDetailsLayout.apply {
            veilLayout.unVeil()
            seriesDetail = series
        }
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
