package com.erkindilekci.borutobook.domain.use_cases.search_heroes

import androidx.paging.PagingData
import com.erkindilekci.borutobook.data.repository.BorutoBookRepository
import com.erkindilekci.borutobook.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class SearchHeroesUseCase(
    private val repository: BorutoBookRepository
) {
    operator fun invoke(query: String): Flow<PagingData<Hero>> {
        return repository.searchHeroes(query)
    }
}
