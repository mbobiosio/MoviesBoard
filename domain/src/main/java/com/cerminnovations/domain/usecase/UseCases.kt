package com.cerminnovations.domain.usecase

import com.cerminnovations.domain.usecase.movies.* // ktlint-disable no-wildcard-imports

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
data class UseCases(
    /*Movies*/
    val getPopularMovies: PopularMoviesUseCase,
    val getTopRatedUseCase: TopRatedUseCase,
    val getUpcomingMoviesUseCase: UpcomingMoviesUseCase,
    val getNowPlayingUseCase: NowPlayingUseCase,
    val getTrendingUseCase: TrendingUseCase,
    val getMovieDetailUseCase: MovieDetailUseCase
)