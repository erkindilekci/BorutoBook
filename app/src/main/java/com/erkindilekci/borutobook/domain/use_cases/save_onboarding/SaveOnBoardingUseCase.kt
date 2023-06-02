package com.erkindilekci.borutobook.domain.use_cases.save_onboarding

import com.erkindilekci.borutobook.data.repository.Repository

class SaveOnBoardingUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnBoardingState(completed)
    }
}
