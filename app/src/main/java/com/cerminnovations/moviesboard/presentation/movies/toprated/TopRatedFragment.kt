package com.cerminnovations.moviesboard.presentation.movies.toprated

import com.cerminnovations.moviesboard.base.BaseFragment
import com.cerminnovations.moviesboard.databinding.FragmentTopRatedMoviesBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@AndroidEntryPoint
class TopRatedFragment : BaseFragment<FragmentTopRatedMoviesBinding>(
    FragmentTopRatedMoviesBinding::inflate
) {

    override fun setupViews() {
    }
}
