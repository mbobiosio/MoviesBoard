package com.cerminnovations.moviesboard.presentation.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import com.cerminnovations.core.util.NavigableStateAdapter
import com.cerminnovations.moviesboard.presentation.movies.nowplaying.NowPlayingFragment
import com.cerminnovations.moviesboard.presentation.movies.popularmovies.PopularMoviesFragment
import com.cerminnovations.moviesboard.presentation.movies.toprated.TopRatedFragment
import com.cerminnovations.moviesboard.presentation.movies.trending.TrendingFragment
import com.cerminnovations.moviesboard.presentation.movies.upcoming.UpcomingFragment

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class HomeViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val tabs: Int
) : NavigableStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount() = tabs

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PopularMoviesFragment()
            1 -> TopRatedFragment()
            2 -> UpcomingFragment()
            3 -> NowPlayingFragment()
            4 -> TrendingFragment()
            else -> createFragment(position)
        }
    }
}
