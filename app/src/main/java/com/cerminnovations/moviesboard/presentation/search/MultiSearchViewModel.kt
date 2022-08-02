package com.cerminnovations.moviesboard.presentation.search

import androidx.lifecycle.*
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.cerminnovations.domain.model.search.SearchResult
import com.cerminnovations.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

/*
* Created by Mbuodile Obiosio on Jan 04, 2021.
* Twitter: @cazewonder
* Nigeria
*/
@HiltViewModel
class MultiSearchViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {

    fun search(query: String, includeAdult: Boolean): LiveData<PagingData<SearchResult>> =
        useCases.getSearchUseCase.invoke(query, includeAdult).asLiveData()
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
}
