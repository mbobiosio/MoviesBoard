package com.cerminnovations.moviesboard.presentation.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cerminnovations.core.constant.Constants
import com.cerminnovations.core.util.Resource
import com.cerminnovations.core.util.UIState
import com.cerminnovations.domain.model.movies.MovieDetail
import com.cerminnovations.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.*
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _uIState: MutableLiveData<DataState> = MutableLiveData()
    val uiState: LiveData<DataState> get() = _uIState

    fun getMovieDetail(
        movieId: Long
    ) {
        _uIState.value = UIState.Loading
        useCases.getMovieDetailUseCase.invoke(
            movieId,
            Constants.apiKey,
            Locale.getDefault().language,
            "images,reviews,credits,videos"
        )
            .onEach { result ->
                _uIState.value = when (result) {
                    is Resource.Loading -> UIState.Loading
                    is Resource.Error -> UIState.Error(
                        result.error
                    )
                    is Resource.Success -> UIState.Success(result.data)
                }
            }.launchIn(viewModelScope)
    }
}

typealias DataState = UIState<MovieDetail>
