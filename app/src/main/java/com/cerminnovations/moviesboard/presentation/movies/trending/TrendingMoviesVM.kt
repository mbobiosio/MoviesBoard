package com.cerminnovations.moviesboard.presentation.movies.trending

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
class TrendingMoviesVM @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    fun getTrendingMovies(): LiveData<PagingData<MovieData>> =
        useCases.getTrendingUseCase.invoke().asLiveData()
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
}
