package com.cerminnovations.moviesboard.presentation.movies.popularmovies

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.cerminnovations.moviesboard.base.BaseContract
import com.cerminnovations.moviesboard.base.BaseFragment
import com.cerminnovations.moviesboard.databinding.FragmentPopularMoviesBinding
import com.cerminnovations.moviesboard.ui.adapter.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@AndroidEntryPoint
class PopularMoviesFragment :
    BaseFragment<FragmentPopularMoviesBinding>(
        FragmentPopularMoviesBinding::inflate
    ),
    BaseContract {

    // private val viewModel by viewModels<PopularMoviesVM>()
    private val movieAdapter by lazy {
        MovieAdapter()
    }

    override fun setupViews() {
        initRecyclerView()

        collectFromViewModel()
    }

    private fun initRecyclerView() = with(binding) {
        movies.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 2)
            adapter = movieAdapter
        }
    }

    private fun collectFromViewModel() {
        // viewModel.getPopularMovies().observe(viewLifecycleOwner) {
        // movieAdapter.submitData(lifecycle, it)
        // }

        lifecycleScope.launch {
            movieAdapter.loadStateFlow.collectLatest {
                Timber.d("${it.mediator?.refresh}")
            }
        }
    }

    override fun observeData() {
    }

    override fun showProgress(isVisible: Boolean) {
    }

    override fun showError(isError: Boolean, error: String?) {
    }
}
