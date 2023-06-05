package com.erkindilekci.borutobook.domain.use_cases.get_all_heroes

import androidx.paging.PagingData
import com.erkindilekci.borutobook.data.repository.BorutoBookRepository
import com.erkindilekci.borutobook.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class GetAllHeroesUseCase(
    private val repository: BorutoBookRepository
) {
    operator fun invoke(): Flow<PagingData<Hero>> {
        return repository.getAllHeroes()
    }
}
