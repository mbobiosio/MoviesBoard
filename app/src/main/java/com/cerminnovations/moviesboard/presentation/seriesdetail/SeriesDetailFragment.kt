package com.cerminnovations.moviesboard.presentation.seriesdetail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.cerminnovations.core.base.BaseContract
import com.cerminnovations.core.base.BaseFragment
import com.cerminnovations.domain.model.series.TvSeriesInfo
import com.cerminnovations.domain.uistate.tv.TvUiState
import com.cerminnovations.moviesboard.databinding.FragmentSeriesDetailsBinding
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

    override fun setupViews() {
        initViews()

        initTvData()

        observeData()
    }

    private fun initViews() = with(binding) {
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
                }

                is TvUiState.Success -> {
                    updateUi(it.result)
                }

                is TvUiState.Error -> {
                    showError(true, it.message?.errorMessage)
                }
            }
        }
    }

    private fun updateUi(series: TvSeriesInfo) = with(binding) {
        Timber.d("Series $series")
        seriesDetail = series
    }

    override fun showProgress(isVisible: Boolean) {
    }

    override fun showError(isError: Boolean, error: String?) {
        Timber.d("Error $error")
    }
}
