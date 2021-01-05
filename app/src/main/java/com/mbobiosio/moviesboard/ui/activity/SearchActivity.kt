package com.mbobiosio.moviesboard.ui.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import com.mbobiosio.moviesboard.R
import com.mbobiosio.moviesboard.databinding.ActivitySearchBinding
import com.mbobiosio.moviesboard.model.search.SearchResult
import com.mbobiosio.moviesboard.ui.adapter.SearchAdapter
import com.mbobiosio.moviesboard.util.navigateArtistDetails
import com.mbobiosio.moviesboard.util.navigateMovieDetails
import com.mbobiosio.moviesboard.util.navigateSeriesDetails
import com.mbobiosio.moviesboard.viewmodels.MultiSearchViewModel
import com.mbobiosio.moviesboard.viewmodels.SearchViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SearchActivity : AppCompatActivity(), (SearchResult) -> Unit {
    private lateinit var binding: ActivitySearchBinding
    private val viewModel by viewModels<MultiSearchViewModel>()
    private val searchViewModel by viewModels<SearchViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        binding.lifecycleOwner = this

        val adapter = SearchAdapter(this)
        binding.results.adapter = adapter

        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    searchViewModel.updateSearchQuery(it)
                    return true
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    searchViewModel.updateSearchQuery(it)
                    when {
                        it.isEmpty() -> {
                            adapter.submitData(lifecycle, PagingData.empty())
                            binding.searchDesc.visibility = View.VISIBLE
                        }
                    }
                }
                return true
            }
        })

        searchViewModel.query.observe(this) {
            viewModel.updateSearch(it)
        }

        viewModel.liveQuery.observe(this) {
            lifecycleScope.launch {
                viewModel.getSearchPaging(it, true).collectLatest { data ->
                    binding.searchDesc.visibility = View.GONE
                    adapter.submitData(data)
                }
            }
        }
    }

    override fun invoke(data: SearchResult) {
        data.let {
            when {
                it.mediaType.equals("person") -> navigateArtistDetails(this, data.id)
                it.mediaType.equals("movie") -> navigateMovieDetails(this, data.id)
                it.mediaType.equals("tv") -> navigateSeriesDetails(this, data.id)
            }
        }
    }
}