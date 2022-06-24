package com.cerminnovations.moviesboard.service.paging.artist

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.cerminnovations.moviesboard.data.remote.api.APIService
import com.cerminnovations.moviesboard.model.artists.Artist
import com.cerminnovations.moviesboard.service.ArtistType
import com.cerminnovations.moviesboard.util.Constants.apiKey

class ArtistsDataSource(
    private val apiService: APIService,
    private val artistType: ArtistType
) : PagingSource<Int, Artist>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Artist> {
        return try {
            val nextPage = params.key ?: 1
            val response = loadPage(nextPage)

            LoadResult.Page(
                data = response,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPage + 1
            )
        } catch (t: Throwable) {
            LoadResult.Error(t)
        }
    }

    private suspend fun loadPage(
        page: Int?
    ): List<Artist> {
        val response = when (artistType) {
            ArtistType.POPULAR -> apiService.getPopularArtists(
                apiKey = apiKey,
                page
            )
            ArtistType.TRENDING_TODAY -> apiService.getTrendingArtists(
                "person",
                "day",
                apiKey = apiKey,
                page
            )
            ArtistType.TRENDING_THIS_WEEK -> apiService.getTrendingArtists(
                "person",
                "week",
                apiKey = apiKey,
                page
            )
        }
        return response.results
    }

    override fun getRefreshKey(state: PagingState<Int, Artist>): Int? {
        TODO("Not yet implemented")
    }
}
