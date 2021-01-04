package com.mbobiosio.moviesboard.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.mbobiosio.moviesboard.R
import com.mbobiosio.moviesboard.databinding.ActivitySearchBinding
import com.mbobiosio.moviesboard.model.search.SearchResult
import com.mbobiosio.moviesboard.ui.adapter.MovieAdapter
import com.mbobiosio.moviesboard.ui.adapter.SearchAdapter
import com.mbobiosio.moviesboard.viewmodels.MultiSearchViewModel
import com.mbobiosio.moviesboard.viewmodels.SearchViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

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
                    Timber.d(query)
                    searchViewModel.updateSearchQuery(query)
                    return true
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchViewModel.updateSearchQuery(newText!!)
                return true
            }
        })

        searchViewModel.query.observe(this) {
            viewModel.updateSearch(it)
        }

        viewModel.liveQuery.observe(this) {
            lifecycleScope.launch {
                viewModel.getSearchPaging(it).collectLatest { data ->
                    adapter.submitData(data)
                }
            }
        }



        /*searchViewModel.liveQuery.observe(this) {
            searchViewModel.updateSearch(it)
            Timber.d(it)
        }
        lifecycleScope.launch {
            searchViewModel.updateSearch("gal")
            Timber.d("Scope")
        }
*/

    }

    override fun invoke(data: SearchResult) {
        Timber.d("$data")
    }
}