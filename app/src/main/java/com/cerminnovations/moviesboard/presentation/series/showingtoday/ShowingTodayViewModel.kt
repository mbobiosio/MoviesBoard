package com.cerminnovations.moviesboard.presentation.series.showingtoday

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
class ShowingTodayViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    fun getShowingTodaySeries(): LiveData<PagingData<TvSeries>> =
        useCases.getShowingTodayTvUseCase.invoke().asLiveData()
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
}
