package com.mbobiosio.moviesboard.service.paging.artist

import androidx.paging.PagingSource
import com.mbobiosio.moviesboard.BuildConfig
import com.mbobiosio.moviesboard.api.APIService
import com.mbobiosio.moviesboard.model.movies.Movie
import com.mbobiosio.moviesboard.service.MovieType

class MovieDataSource(
    private val apiService: APIService,
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
                    BuildConfig.API_KEY,
                    language,
                    page,
                    region
                )
            }
            MovieType.TOP_RATED -> {
                apiService.getTopRatedMovies(
                    BuildConfig.API_KEY,
                    language,
                    page,
                    region
                )
            }
            MovieType.UPCOMING -> {
                apiService.getUpcomingMovies(
                    BuildConfig.API_KEY,
                    language,
                    page,
                    region
                )
            }
            MovieType.NOW_PLAYING -> {
                apiService.getNowPlayingMovies(
                    BuildConfig.API_KEY,
                    language,
                    page,
                    region
                )
            }
            MovieType.TRENDING_DAILY -> {
                apiService.getTrendingMovies(
                    BuildConfig.API_KEY,
                    "movie",
                    "day",
                    page,
                    language
                )
            }
            MovieType.TRENDING_WEEKLY -> {
                apiService.getTrendingMovies(
                    BuildConfig.API_KEY,
                    "movie",
                    "week",
                    page,
                    language
                )
            }
        }
        return response.results
    }

}