package com.cerminnovations.moviesboard.presentation.movies.popularmovies

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.cerminnovations.core.base.BaseContract
import com.cerminnovations.core.base.BaseFragment
import com.cerminnovations.domain.model.movies.MovieData
import com.cerminnovations.moviesboard.R
import com.cerminnovations.moviesboard.databinding.FragmentMoviesBinding
import com.cerminnovations.moviesboard.presentation.moviedetail.MovieDetailFragmentArgs
import com.cerminnovations.moviesboard.presentation.movies.MovieAdapter
import com.cerminnovations.moviesboard.presentation.movies.interfaces.MovieItemClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@AndroidEntryPoint
class PopularMoviesFragment :
    BaseFragment<FragmentMoviesBinding>(
        FragmentMoviesBinding::inflate
    ),
    BaseContract {

    private val viewModel by viewModels<PopularMoviesVM>()
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

        movieAdapter.itemClickListener = object : MovieItemClickListener {
            override fun onItemClick(movieData: MovieData) {
                findNavController().navigate(
                    R.id.movieDetailFragment,
                    MovieDetailFragmentArgs(movieData).toBundle()
                )
            }
        }
    }

    override fun observeData() {
        viewModel.getPopularMovies().observe(viewLifecycleOwner) {
            movieAdapter.submitData(lifecycle, it)
        }

        lifecycleScope.launch {
            movieAdapter.loadStateFlow.collectLatest { loadState ->

                // val isListEmpty = loadState.refresh is LoadState.NotLoading && movieAdapter.itemCount == 0
                // Timber.d("List $isListEmpty")

                val isLoading = loadState.mediator?.refresh is LoadState.Loading
                showProgress(isLoading)
            }
        }
    }

    override fun showProgress(isVisible: Boolean) = with(binding) {
        progress.isVisible = isVisible
    }

    override fun showError(isError: Boolean, error: String?) {
    }
}
