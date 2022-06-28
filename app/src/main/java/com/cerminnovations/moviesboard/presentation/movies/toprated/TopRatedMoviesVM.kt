package com.cerminnovations.moviesboard.presentation.movies.toprated

import androidx.lifecycle.* // ktlint-disable no-wildcard-imports
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.cerminnovations.moviesboard.domain.model.MovieData
import com.cerminnovations.moviesboard.domain.usecase.movies.TopRatedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@HiltViewModel
class TopRatedMoviesVM @Inject constructor(
    private val useCase: TopRatedUseCase
) : ViewModel() {

    fun getTopRatedMovies(): LiveData<PagingData<MovieData>> =
        useCase.invoke().asLiveData()
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
}