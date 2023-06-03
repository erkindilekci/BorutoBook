package com.erkindilekci.borutobook.presentation.listscreen

import androidx.lifecycle.ViewModel
import com.erkindilekci.borutobook.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    val getAllHeroes = useCases.getAllHeroesUseCase()
}
