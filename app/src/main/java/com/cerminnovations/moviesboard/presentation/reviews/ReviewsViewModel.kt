package com.cerminnovations.moviesboard.presentation.reviews

import androidx.lifecycle.ViewModel
import com.cerminnovations.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@HiltViewModel
class ReviewsViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    fun getReviews() {
    }
}
