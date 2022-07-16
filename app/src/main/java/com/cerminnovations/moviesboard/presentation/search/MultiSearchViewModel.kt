package com.cerminnovations.moviesboard.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingConfig
import timber.log.Timber

/*
* Created by Mbuodile Obiosio on Jan 04, 2021.
* Twitter: @cazewonder
* Nigeria
*/
class MultiSearchViewModel : ViewModel() {

    private val queryData = MutableLiveData<String>()
    val liveQuery: LiveData<String>
        get() = queryData

    // private fun getDataSource(query: String, adult: Boolean) = SearchDataSource(apiService, query, adult)

    private val pagingConfig =
        PagingConfig(pageSize = 20, initialLoadSize = 10, enablePlaceholders = false)

    // fun getSearchPaging(query: String, adult: Boolean) = Pager(pagingConfig) {
    //    getDataSource(query, adult)
    // }.flow.cachedIn(viewModelScope)

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
