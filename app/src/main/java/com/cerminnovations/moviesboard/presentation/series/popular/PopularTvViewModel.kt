package com.cerminnovations.moviesboard.presentation.series.popular

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
class PopularTvViewModel @Inject constructor(
    private val useCase: UseCases
) : ViewModel() {

    init {
        getPopularSeries()
    }

    fun getPopularSeries(): LiveData<PagingData<TvSeries>> =
        useCase.getPopularTvUseCase.invoke().asLiveData()
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
}
