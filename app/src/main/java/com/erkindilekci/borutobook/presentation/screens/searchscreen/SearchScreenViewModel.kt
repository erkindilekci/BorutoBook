package com.erkindilekci.borutobook.presentation.screens.searchscreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.erkindilekci.borutobook.domain.model.Hero
import com.erkindilekci.borutobook.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    var searchQuery = mutableStateOf("")
        private set

    private val _searchedHeroes = MutableStateFlow<PagingData<Hero>>(PagingData.empty())
    val searchedHeroes: StateFlow<PagingData<Hero>> = _searchedHeroes.asStateFlow()

    fun updateSearchQuery(newQuery: String) {
        searchQuery.value = newQuery
    }

    fun searchHeroes(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.searchHeroesUseCase(query).cachedIn(this).collect { pagingData ->
                _searchedHeroes.value = pagingData
            }
        }
    }
}
