package com.cerminnovations.moviesboard.presentation.series

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import com.cerminnovations.core.util.NavigableStateAdapter
import com.cerminnovations.moviesboard.presentation.series.nowshowing.NowShowingTvFragment
import com.cerminnovations.moviesboard.presentation.series.popular.PopularSeriesFragment
import com.cerminnovations.moviesboard.presentation.series.showingtoday.ShowingTodayTvFragment
import com.cerminnovations.moviesboard.presentation.series.toprated.TopRatedTvFragment
import com.cerminnovations.moviesboard.presentation.series.trendingtoday.TrendingTodayTvFragment
import com.cerminnovations.moviesboard.presentation.series.trendingweek.TrendingWeekTvFragment

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class SeriesPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val tabs: Int
) : NavigableStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount() = tabs

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PopularSeriesFragment()
            1 -> TopRatedTvFragment()
            2 -> NowShowingTvFragment()
            3 -> ShowingTodayTvFragment()
            4 -> TrendingTodayTvFragment()
            5 -> TrendingWeekTvFragment()
            else -> createFragment(position)
        }
    }
}
