package com.cerminnovations.domain.repository.reviews

import androidx.paging.PagingData
import com.cerminnovations.domain.model.review.Review
import kotlinx.coroutines.flow.Flow

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
interface ReviewsUseCase {
    fun getReviews(): Flow<PagingData<Review>>
}
