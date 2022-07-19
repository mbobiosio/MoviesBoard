package com.cerminnovations.moviesboard.data.remote.model.search

import com.cerminnovations.moviesboard.data.remote.model.response.Response
import com.squareup.moshi.Json

/*
* Created by Mbuodile Obiosio on Jan 04, 2021.
* Twitter: @cazewonder
* Nigeria
*/
data class SearchDto(
    @Json(name = "page")
    val page: Int?,
    @Json(name = "results")
    val results: List<SearchResultDto>,
    @Json(name = "total_pages")
    val totalPages: Int?,
    @Json(name = "total_results")
    val totalResults: Int?
) : Response
