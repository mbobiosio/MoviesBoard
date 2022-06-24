package com.cerminnovations.moviesboard.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/*
* Created by Mbuodile Obiosio on Jan 04, 2021.
* Twitter: @cazewonder
* Nigeria
*/
class SearchViewModel : ViewModel() {
    private val _query = MutableLiveData<String>()

    val query: LiveData<String>
        get() = _query

    fun updateSearchQuery(query: String) {
        _query.postValue(query)
    }
}
