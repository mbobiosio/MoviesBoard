package com.cerminnovations.moviesboard.presentation.people

import androidx.lifecycle.* // ktlint-disable no-wildcard-imports
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.cerminnovations.domain.model.people.Person
import com.cerminnovations.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    fun getPeople(): LiveData<PagingData<Person>> =
        useCases.getPeopleUseCase.invoke().asLiveData()
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
}
