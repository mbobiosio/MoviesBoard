package com.cerminnovations.moviesboard.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.cerminnovations.moviesboard.api.RetrofitClient
import com.cerminnovations.moviesboard.service.MovieType
import com.cerminnovations.moviesboard.service.paging.movie.MovieDataSource

class AllMoviesViewModel : ViewModel() {

    private val apiService = RetrofitClient.apiService

    private fun dataSource(movieType: MovieType) = MovieDataSource(
        apiService, movieType
    )

    private val pagingConfig = PagingConfig(
        pageSize = 20,
        initialLoadSize = 10,
        enablePlaceholders = true
    )

    fun getMoviesFlow(movieType: MovieType) = Pager(pagingConfig) {
        dataSource(movieType)
    }.flow.cachedIn(viewModelScope)
}