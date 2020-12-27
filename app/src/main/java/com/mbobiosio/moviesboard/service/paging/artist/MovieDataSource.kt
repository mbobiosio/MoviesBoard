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
        apiKey: String? = null,
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
                    apiKey,
                    language,
                    page,
                    region
                )
            }
            MovieType.UPCOMING -> {
                apiService.getUpcomingMovies(
                    apiKey,
                    language,
                    page,
                    region
                )
            }
            MovieType.NOW_PLAYING -> {
                apiService.getNowPlayingMovies(
                    apiKey,
                    language,
                    page,
                    region
                )
            }
            MovieType.TRENDING_DAILY -> {
                apiService.getTrendingMovies(
                    apiKey,
                    "movie",
                    "day",
                    page,
                    language
                )
            }
            MovieType.TRENDING_WEEKLY -> {
                apiService.getTrendingMovies(
                    apiKey,
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