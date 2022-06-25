package com.cerminnovations.moviesboard.presentation.movies.toprated

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.cerminnovations.moviesboard.base.BaseContract
import com.cerminnovations.moviesboard.base.BaseFragment
import com.cerminnovations.moviesboard.databinding.FragmentTopRatedMoviesBinding
import com.cerminnovations.moviesboard.presentation.movies.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@AndroidEntryPoint
class TopRatedFragment :
    BaseFragment<FragmentTopRatedMoviesBinding>(
        FragmentTopRatedMoviesBinding::inflate
    ),
    BaseContract {

    private val viewModel by viewModels<TopRatedMoviesVM>()
    private val movieAdapter by lazy {
        MovieAdapter()
    }

    override fun setupViews() {
        initRecyclerView()
        observeData()
    }

    private fun initRecyclerView() = with(binding) {
        movies.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 2)
            adapter = movieAdapter
        }
    }

    override fun observeData() {
        viewModel.getTopRatedMovies().observe(viewLifecycleOwner) {
            movieAdapter.submitData(lifecycle, it)
        }

        lifecycleScope.launch {
            movieAdapter.loadStateFlow.collectLatest {
                Timber.d("${it.mediator?.refresh}")
            }
        }
    }

    override fun showProgress(isVisible: Boolean) {
    }

    override fun showError(isError: Boolean, error: String?) {
    }
}
