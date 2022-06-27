package com.cerminnovations.moviesboard.service.paging.movie

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.cerminnovations.moviesboard.model.movies.Movie
import com.cerminnovations.moviesboard.service.MovieType

class MovieDataSource(
    private val apiService: com.cerminnovations.moviesboard.api.APIService,
    private val queryType: MovieType
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextPage = params.key ?: 1
            val response = loadPage(page = nextPage)

            LoadResult.Page(
                data = response,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPage + 1
            )
        } catch (e: Throwable) {
            LoadResult.Error(e)
        }
    }

    private suspend fun loadPage(
        language: String? = null,
        page: Int?,
        region: String? = null
    ): List<Movie> {

        val response = when (queryType) {
            MovieType.POPULAR -> {
                apiService.getPopularMovies(
                    com.cerminnovations.moviesboard.BuildConfig.API_KEY,
                    language,
                    page,
                    region
                )
            }
            MovieType.TOP_RATED -> {
                apiService.getTopRatedMovies(
                    com.cerminnovations.moviesboard.BuildConfig.API_KEY,
                    language,
                    page,
                    region
                )
            }
            MovieType.UPCOMING -> {
                apiService.getUpcomingMovies(
                    com.cerminnovations.moviesboard.BuildConfig.API_KEY,
                    language,
                    page,
                    region
                )
            }
            MovieType.NOW_PLAYING -> {
                apiService.getNowPlayingMovies(
                    com.cerminnovations.moviesboard.BuildConfig.API_KEY,
                    language,
                    page,
                    region
                )
            }
            MovieType.TRENDING_TODAY -> {
                apiService.getTrendingMovies(
                    "movie",
                    "day",
                    com.cerminnovations.moviesboard.BuildConfig.API_KEY,
                    page
                )
            }
            MovieType.TRENDING_THIS_WEEK -> {
                apiService.getTrendingMovies(
                    "movie",
                    "week",
                    com.cerminnovations.moviesboard.BuildConfig.API_KEY,
                    page
                )
            }
        }
        return response.results
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>) =
        state.anchorPosition
}
