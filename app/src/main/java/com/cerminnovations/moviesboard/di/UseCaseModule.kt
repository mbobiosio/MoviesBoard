package com.cerminnovations.moviesboard.di

import androidx.paging.ExperimentalPagingApi
import com.cerminnovations.domain.usecase.UseCases
import com.cerminnovations.domain.usecase.favorite.MovieFavoriteUseCase
import com.cerminnovations.domain.usecase.movies.*
import com.cerminnovations.domain.usecase.people.PeopleInfoUseCase
import com.cerminnovations.domain.usecase.people.PeopleUseCase
import com.cerminnovations.domain.usecase.search.SearchUseCase
import com.cerminnovations.domain.usecase.series.*
import com.cerminnovations.moviesboard.data.remote.repository.favorite.MovieFavoriteRepoImpl
import com.cerminnovations.moviesboard.data.remote.repository.movies.*
import com.cerminnovations.moviesboard.data.remote.repository.people.PeopleRepositoryImpl
import com.cerminnovations.moviesboard.data.remote.repository.search.SearchRepositoryImpl
import com.cerminnovations.moviesboard.data.remote.repository.tv.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Module
@InstallIn(SingletonComponent::class)
@ExperimentalPagingApi
class UseCaseModule {

    @Provides
    @Singleton
    fun provideUseCases(
        popularMovieRepositoryImpl: PopularMovieRepoImpl,
        topRatedMoviesRepoImpl: TopRatedMoviesRepoImpl,
        upcomingMoviesRepoImpl: UpcomingMoviesRepoImpl,
        nowPlayingRepoImpl: NowPlayingRepoImpl,
        trendingMoviesRepoImpl: TrendingMoviesRepoImpl,
        movieDetailRepoImpl: MovieDetailRepoImpl,
        /*
        * Tv
        * */
        popularTvRepoImpl: PopularTvRepoImpl,
        topRatedTvRepoImpl: TopRatedTvRepoImpl,
        nowShowingTvRepoImpl: NowShowingTvRepoImpl,
        showingTodayTvRepoImpl: ShowingTodayTvRepoImpl,
        trendingTodayTvRepoImpl: TrendingTodayTvRepoImpl,
        trendingWeekRepoImpl: TrendingWeekRepoImpl,
        tvDetailRepoImpl: SeriesDetailRepoImpl,
        peopleRepositoryImpl: PeopleRepositoryImpl,

        /*
        * Multi Search
        * */
        multiSearchRepoImpl: SearchRepositoryImpl,

        /*
        * Favorites
        * */
        movieFavoriteRepository: MovieFavoriteRepoImpl,
    ) =
        UseCases(
            /*
            * Movie
            * */
            getPopularMovies = PopularMoviesUseCase(popularMovieRepositoryImpl),
            getTopRatedUseCase = TopRatedUseCase(topRatedMoviesRepoImpl),
            getUpcomingMoviesUseCase = UpcomingMoviesUseCase(upcomingMoviesRepoImpl),
            getNowPlayingUseCase = NowPlayingUseCase(nowPlayingRepoImpl),
            getTrendingUseCase = TrendingUseCase(trendingMoviesRepoImpl),
            getMovieDetailUseCase = MovieDetailUseCase(movieDetailRepoImpl),

            /*
            * Tv
            * */
            getPopularTvUseCase = PopularTvUseCase(popularTvRepoImpl),
            getTopRatedTvUseCase = TopRatedTvUseCase(topRatedTvRepoImpl),
            getNowShowingTvUseCase = NowShowingTvUseCase(nowShowingTvRepoImpl),
            getShowingTodayTvUseCase = ShowingTodayTvUseCase(showingTodayTvRepoImpl),
            getTrendingTodayTvUseCase = TrendingTodayTvUseCase(trendingTodayTvRepoImpl),
            getTrendingWeekUseCase = TrendingWeekUseCase(trendingWeekRepoImpl),
            getSeriesDetailUseCase = SeriesDetailUseCase(tvDetailRepoImpl),

            /*
            * People
            * */
            getPeopleUseCase = PeopleUseCase(peopleRepositoryImpl),
            getPeopleInfoUseCase = PeopleInfoUseCase(peopleRepositoryImpl),

            /*
            * Multi Search
            * */
            getSearchUseCase = SearchUseCase(multiSearchRepoImpl),

            /*
            * Favorites
            * */
            getMovieFavoriteUseCase = MovieFavoriteUseCase(movieFavoriteRepository)
        )
}
