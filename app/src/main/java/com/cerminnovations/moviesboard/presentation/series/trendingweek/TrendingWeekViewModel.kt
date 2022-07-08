package com.cerminnovations.moviesboard.presentation.series.trendingweek

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
class TrendingWeekViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    fun getTrendingWeekSeries(): LiveData<PagingData<TvSeries>> =
        useCases.getTrendingWeekUseCase.invoke().asLiveData()
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
}
