package com.cerminnovations.domain.usecase

import com.cerminnovations.domain.usecase.movies.* // ktlint-disable no-wildcard-imports
import com.cerminnovations.domain.usecase.series.PopularTvUseCase
import com.cerminnovations.domain.usecase.series.TopRatedTvUseCase

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
    val getMovieDetailUseCase: MovieDetailUseCase,

    /*
    * Tv
    * */
    val getPopularTvUseCase: PopularTvUseCase,
    val getTopRatedTvUseCase: TopRatedTvUseCase
)
