package com.cerminnovations.domain.usecase.favorite

import com.cerminnovations.domain.repository.favorite.MovieFavoriteRepository
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class MovieFavoriteUseCase @Inject constructor(
    private val movieFavoriteRepository: MovieFavoriteRepository,
) {

}