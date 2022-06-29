package com.cerminnovations.moviesboard.presentation.movies.toprated

import androidx.lifecycle.* // ktlint-disable no-wildcard-imports
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.cerminnovations.domain.model.MovieData
import com.cerminnovations.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@HiltViewModel
class TopRatedMoviesVM @Inject constructor(
    private val useCase: UseCases
) : ViewModel() {

    fun getTopRatedMovies(): LiveData<PagingData<MovieData>> =
        useCase.getTopRatedUseCase.invoke().asLiveData()
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
}
