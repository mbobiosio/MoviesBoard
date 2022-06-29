package com.cerminnovations.moviesboard.presentation.movies.trending

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.cerminnovations.domain.model.MovieData
import com.cerminnovations.moviesboard.base.BaseContract
import com.cerminnovations.moviesboard.base.BaseFragment
import com.cerminnovations.moviesboard.databinding.FragmentTrendingMoviesBinding
import com.cerminnovations.moviesboard.presentation.movies.MovieAdapter
import com.cerminnovations.moviesboard.presentation.movies.interfaces.MovieItemClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@AndroidEntryPoint
class TrendingFragment :
    BaseFragment<FragmentTrendingMoviesBinding>(
        FragmentTrendingMoviesBinding::inflate
    ),
    BaseContract {

    private val viewModel by viewModels<TrendingMoviesVM>()
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
                Timber.d("Movie $movieData")
                /*findNavController().navigate(
                    R.id.movieDetailFragment,
                    MovieDetailFragmentArgs(movieData).toBundle()
                )*/
            }
        }
    }

    override fun observeData() {
        viewModel.getTrendingMovies().observe(viewLifecycleOwner) {
            movieAdapter.submitData(lifecycle, it)
        }

        lifecycleScope.launch {
            movieAdapter.loadStateFlow.collectLatest {
            }
        }
    }

    override fun showProgress(isVisible: Boolean) {
    }

    override fun showError(isError: Boolean, error: String?) {
    }
}
