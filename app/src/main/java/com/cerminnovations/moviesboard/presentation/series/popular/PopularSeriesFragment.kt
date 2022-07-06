package com.cerminnovations.moviesboard.presentation.series.popular

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.cerminnovations.core.base.BaseContract
import com.cerminnovations.core.base.BaseFragment
import com.cerminnovations.moviesboard.databinding.FragmentSeriesBinding
import com.cerminnovations.moviesboard.presentation.series.SeriesAdapter
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@AndroidEntryPoint
class PopularSeriesFragment :
    BaseFragment<FragmentSeriesBinding>(
        FragmentSeriesBinding::inflate
    ),
    BaseContract {

    private val viewModel by viewModels<PopularTvViewModel>()
    private val seriesAdapter by lazy {
        SeriesAdapter()
    }

    override fun setupViews() {
        observeData()

        // init recycler view
        initRecyclerView()
    }

    private fun initRecyclerView() = with(binding) {
        series.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = seriesAdapter
        }
    }

    override fun observeData() {
        viewModel.getPopularSeries().observe(viewLifecycleOwner) {
            seriesAdapter.submitData(lifecycle, it)
        }
    }

    override fun showProgress(isVisible: Boolean) {
        TODO("Not yet implemented")
    }

    override fun showError(isError: Boolean, error: String?) {
        TODO("Not yet implemented")
    }
}
