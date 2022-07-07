package com.cerminnovations.moviesboard.presentation.series.toprated

import androidx.lifecycle.* // ktlint-disable no-wildcard-imports
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.cerminnovations.domain.model.series.TvSeries
import com.cerminnovations.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@HiltViewModel
class TopRatedTvViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    fun getTopRatedTvSeries(): LiveData<PagingData<TvSeries>> =
        useCases.getTopRatedTvUseCase.invoke().asLiveData()
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
}
