package com.cerminnovations.moviesboard.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.cerminnovations.moviesboard.data.remote.api.RetrofitClient
import com.cerminnovations.moviesboard.service.SeriesType
import com.cerminnovations.moviesboard.service.paging.series.SeriesDataSource

class AllSeriesViewModel : ViewModel() {
    private val apiService = RetrofitClient.apiService

    private fun getDataSource(seriesType: SeriesType) = SeriesDataSource(apiService, seriesType)

    private val pagingConfig =
        PagingConfig(pageSize = 20, initialLoadSize = 5, enablePlaceholders = true)

    fun getPagingFlow(seriesType: SeriesType) = Pager(pagingConfig) {
        getDataSource(seriesType)
    }.flow.cachedIn(viewModelScope)
}
