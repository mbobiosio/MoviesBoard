package com.cerminnovations.domain.usecase

import com.cerminnovations.domain.usecase.movies.* // ktlint-disable no-wildcard-imports
import com.cerminnovations.domain.usecase.people.PeopleUseCase
import com.cerminnovations.domain.usecase.series.* // ktlint-disable no-wildcard-imports

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
    val getTopRatedTvUseCase: TopRatedTvUseCase,
    val getNowShowingTvUseCase: NowShowingTvUseCase,
    val getShowingTodayTvUseCase: ShowingTodayTvUseCase,
    val getTrendingTodayTvUseCase: TrendingTodayTvUseCase,
    val getTrendingWeekUseCase: TrendingWeekUseCase,
    val getSeriesDetailUseCase: SeriesDetailUseCase,

    /*
    * People
    * */
    val getPeopleUseCase: PeopleUseCase
)
