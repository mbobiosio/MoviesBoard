package com.mbobiosio.moviesboard.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.mbobiosio.moviesboard.api.RetrofitClient
import com.mbobiosio.moviesboard.service.SeriesType
import com.mbobiosio.moviesboard.service.paging.series.SeriesDataSource

class AllSeriesViewModel : ViewModel() {
    private val apiService = RetrofitClient.apiService

    private fun getDataSource(seriesType: SeriesType) = SeriesDataSource(apiService, seriesType)

    private val pagingConfig =
        PagingConfig(pageSize = 20, initialLoadSize = 5, enablePlaceholders = true)

    fun getPagingFlow(seriesType: SeriesType) = Pager(pagingConfig) {
        getDataSource(seriesType)
    }.flow.cachedIn(viewModelScope)
}