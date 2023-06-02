package com.erkindilekci.borutobook.data.repository

import androidx.paging.PagingData
import com.erkindilekci.borutobook.domain.model.Hero
import com.erkindilekci.borutobook.domain.repository.DataStoreRepository
import com.erkindilekci.borutobook.domain.repository.RemoteDataSourceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: RemoteDataSourceRepository,
    private val dataStore: DataStoreRepository
) {

    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return remote.getAllHeroes()
    }

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }
}
