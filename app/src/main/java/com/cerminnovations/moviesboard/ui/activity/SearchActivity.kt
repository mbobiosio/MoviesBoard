package com.cerminnovations.moviesboard.ui.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import com.cerminnovations.domain.model.search.SearchResult
import com.cerminnovations.moviesboard.R
import com.cerminnovations.moviesboard.data.remote.model.search.SearchResultDto
import com.cerminnovations.moviesboard.databinding.ActivitySearchBinding
import com.cerminnovations.moviesboard.presentation.search.MultiSearchViewModel
import com.cerminnovations.moviesboard.presentation.search.SearchViewModel
import com.cerminnovations.moviesboard.ui.adapter.SearchAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
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
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                doMultiSearch(newText, adapter)
                newText?.let {
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
    }

    private fun doMultiSearch(query: String?, adapter: SearchAdapter) {
        query?.let {
            viewModel.search(it, true).observe(this) { data ->
                adapter.submitData(lifecycle, data)
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
}
