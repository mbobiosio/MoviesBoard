package com.cerminnovations.moviesboard.presentation.movies.trending

import androidx.lifecycle.* // ktlint-disable no-wildcard-imports
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.cerminnovations.moviesboard.domain.model.MovieData
import com.cerminnovations.moviesboard.domain.usecase.movies.TrendingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@HiltViewModel
class TrendingMoviesVM @Inject constructor(
    private val trendingUseCase: TrendingUseCase
) : ViewModel() {

    fun getTrendingMovies(): LiveData<PagingData<MovieData>> =
        trendingUseCase.invoke().asLiveData()
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
}
