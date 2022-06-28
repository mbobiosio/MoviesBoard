package com.cerminnovations.moviesboard.presentation.movies.upcoming

import androidx.lifecycle.* // ktlint-disable no-wildcard-imports
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.cerminnovations.moviesboard.domain.model.MovieData
import com.cerminnovations.moviesboard.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@HiltViewModel
class UpcomingMoviesVM @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    fun getUpcomingMovies(): LiveData<PagingData<MovieData>> =
        useCases.getUpcomingMoviesUseCase.invoke().asLiveData()
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
}
