package com.erkindilekci.borutobook.domain.use_cases.save_onboarding

import com.erkindilekci.borutobook.data.repository.BorutoBookRepository

class SaveOnBoardingUseCase(
    private val repository: BorutoBookRepository
) {
    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnBoardingState(completed)
    }
}
