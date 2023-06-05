package com.erkindilekci.borutobook.domain.use_cases.get_selected_hero

import com.erkindilekci.borutobook.data.repository.BorutoBookRepository
import com.erkindilekci.borutobook.domain.model.Hero

class GetSelectedHeroUseCase(
    private val repository: BorutoBookRepository
) {
    suspend operator fun invoke(heroId: Int): Hero {
        return repository.getSelectedHero(heroId)
    }
}
