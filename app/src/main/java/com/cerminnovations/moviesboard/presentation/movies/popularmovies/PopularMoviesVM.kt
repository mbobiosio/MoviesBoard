package com.cerminnovations.moviesboard.presentation.movies.popularmovies

import androidx.lifecycle.* // ktlint-disable no-wildcard-imports
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.cerminnovations.moviesboard.data.local.entities.popular.PopularMovie
import com.cerminnovations.moviesboard.domain.usecase.PopularMoviesUseCase
import com.cerminnovations.moviesboard.service.MovieType
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@HiltViewModel
class PopularMoviesVM @Inject constructor(
    private val moviesUseCase: PopularMoviesUseCase
) : ViewModel() {

    fun updateQueryType(query: MovieType) {
        Timber.d("Query $query")
        when (query) {
            MovieType.POPULAR -> getPopularMovies()
            else -> getPopularMovies()
        }
    }

    fun getPopularMovies(): LiveData<PagingData<PopularMovie>> =
        moviesUseCase.invoke().asLiveData()
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
}
