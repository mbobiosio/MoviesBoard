package com.cerminnovations.core.util.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
abstract class IndexingPagingSource<T : Any> : PagingSource<Int, T>() {
    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition?.let { position ->
            val anchorPage = state.closestPageToPosition(position)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}