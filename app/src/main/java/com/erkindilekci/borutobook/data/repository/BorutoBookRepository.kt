package com.erkindilekci.borutobook.data.repository

import androidx.paging.PagingData
import com.erkindilekci.borutobook.domain.model.Hero
import com.erkindilekci.borutobook.domain.repository.DataStoreRepository
import com.erkindilekci.borutobook.domain.repository.LocalDataSource
import com.erkindilekci.borutobook.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BorutoBookRepository @Inject constructor(
    private val remote: RemoteDataSource,
    private val local: LocalDataSource,
    private val dataStore: DataStoreRepository
) {

    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return remote.getAllHeroes()
    }

    fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return remote.searchAllHeroes(query)
    }

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }

    suspend fun getSelectedHero(heroId: Int): Hero {
        return local.getSelectedHero(heroId)
    }
}
