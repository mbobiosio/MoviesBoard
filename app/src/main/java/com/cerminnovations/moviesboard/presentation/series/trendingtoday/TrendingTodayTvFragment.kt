package com.cerminnovations.moviesboard.presentation.series.trendingtoday

import com.cerminnovations.core.base.BaseContract
import com.cerminnovations.core.base.BaseFragment
import com.cerminnovations.moviesboard.databinding.FragmentSeriesBinding

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class TrendingTodayTvFragment :
    BaseFragment<FragmentSeriesBinding>(
        FragmentSeriesBinding::inflate
    ),
    BaseContract {

    override fun setupViews() {
        initViews()
    }

    private fun initViews() = with(binding) {
    }

    override fun observeData() {
        TODO("Not yet implemented")
    }

    override fun showProgress(isVisible: Boolean) {
        TODO("Not yet implemented")
    }

    override fun showError(isError: Boolean, error: String?) {
        TODO("Not yet implemented")
    }
}
