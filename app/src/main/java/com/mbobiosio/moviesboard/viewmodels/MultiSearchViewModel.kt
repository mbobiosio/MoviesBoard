package com.mbobiosio.moviesboard.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.mbobiosio.moviesboard.api.RetrofitClient
import com.mbobiosio.moviesboard.service.paging.search.SearchDataSource
import timber.log.Timber

/*
* Created by Mbuodile Obiosio on Jan 04, 2021.
* Twitter: @cazewonder
* Nigeria
*/
class MultiSearchViewModel : ViewModel() {

    private val apiService = RetrofitClient.apiService

    private val queryData = MutableLiveData<String>()
    val liveQuery: LiveData<String>
        get() = queryData

    private fun getDataSource(query: String) = SearchDataSource(
        apiService, query
    )

    private val pagingConfig = PagingConfig(pageSize = 20, initialLoadSize = 10, enablePlaceholders = false)

    fun getSearchPaging(query: String) = Pager(pagingConfig) {
        getDataSource(query)
    }.flow.cachedIn(viewModelScope)

    fun updateSearch(query: String) {
        Timber.d(query)
        if (query == queryData.value) return
        if (query.isNotEmpty() && query.isNotBlank()) {
            query.trim().apply {
                queryData.postValue(query)
            }
        }
    }
}