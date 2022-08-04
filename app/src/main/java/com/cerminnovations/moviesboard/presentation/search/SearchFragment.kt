package com.cerminnovations.moviesboard.presentation.search

import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import androidx.paging.PagingData
import com.cerminnovations.core.base.BaseContract
import com.cerminnovations.core.base.BaseFragment
import com.cerminnovations.domain.model.search.SearchResult
import com.cerminnovations.moviesboard.databinding.FragmentSearchBinding
import com.cerminnovations.moviesboard.ui.adapter.SearchAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>(
    FragmentSearchBinding::inflate
), (SearchResult) -> Unit, BaseContract {

    private val viewModel by viewModels<MultiSearchViewModel>()
    private val adapter by lazy {
        SearchAdapter(this)
    }

    override fun setupViews() {
        initViews()
        observeData()
    }

    private fun initViews() = with(binding) {
        results.adapter = adapter

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    when {
                        it.isNotEmpty() -> doMultiSearch(it)
                        it.isEmpty() -> {
                            adapter.submitData(lifecycle, PagingData.empty())
                            searchDesc.visibility = View.VISIBLE
                        }
                    }
                }
                return true
            }
        })
    }

    private fun doMultiSearch(query: String?) {
        query?.let {
            viewModel.search(it, true).observe(this) { data ->
                adapter.submitData(lifecycle, data)
            }
        }
    }

    override fun observeData() {
        adapter.addLoadStateListener { state ->
            val errorState = state.source.append as? LoadState.Error
                ?: state.source.prepend as? LoadState.Error
                ?: state.append as? LoadState.Error
                ?: state.prepend as? LoadState.Error

            errorState?.let {
                Timber.d("Error ${it.error} : True ${it.error.equals(true)} : False ${it.error.equals(false)}")
            }
        }
    }

    override fun invoke(data: SearchResult) {
        data.let {
            when {
                it.mediaType.equals("person") -> {
                    // navigateArtistDetails(this, data.id)
                }
                it.mediaType.equals("movie") -> {
                    // navigateMovieDetails(this, data.id)
                }
                it.mediaType.equals("tv") -> {
                    // navigateSeriesDetails(this, data.id)
                }
            }
        }
    }

    override fun showProgress(isVisible: Boolean) {
        TODO("Not yet implemented")
    }

    override fun showError(isError: Boolean, error: String?) {
        TODO("Not yet implemented")
    }
}
