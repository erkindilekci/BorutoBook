package com.erkindilekci.borutobook.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.erkindilekci.borutobook.data.data_source.remote.BorutoBookApi
import com.erkindilekci.borutobook.domain.model.Hero

class SearchHeroesSource(
    private val api: BorutoBookApi,
    private val query: String
) : PagingSource<Int, Hero>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hero> {
        return try {
            val apiResponse = api.searchHeroes(query)
            val heroes = apiResponse.heroes.map { it.toHero() }
            if (heroes.isNotEmpty()) {
                LoadResult.Page(
                    data = heroes,
                    prevKey = apiResponse.prevPage,
                    nextKey = apiResponse.nextPage
                )
            } else {
                LoadResult.Page(data = emptyList(), prevKey = null, nextKey = null)
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Hero>): Int? {
        return state.anchorPosition
    }
}
