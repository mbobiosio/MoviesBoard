package com.cerminnovations.moviesboard.presentation.movies.popularmovies

import androidx.lifecycle.* // ktlint-disable no-wildcard-imports
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.cerminnovations.domain.model.movies.MovieData
import com.cerminnovations.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@HiltViewModel
class PopularMoviesVM @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    fun getPopularMovies(): LiveData<PagingData<MovieData>> =
        useCases.getPopularMovies.invoke().asLiveData()
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
}
