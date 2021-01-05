package com.mbobiosio.moviesboard.model.search

import com.mbobiosio.moviesboard.model.response.Response
import com.squareup.moshi.Json

/*
* Created by Mbuodile Obiosio on Jan 04, 2021.
* Twitter: @cazewonder
* Nigeria
*/
data class Search(
    @Json(name = "page")
    val page: Int?,
    @Json(name = "results")
    val results: List<SearchResult>,
    @Json(name = "total_pages")
    val totalPages: Int?,
    @Json(name = "total_results")
    val totalResults: Int?
) : Response
