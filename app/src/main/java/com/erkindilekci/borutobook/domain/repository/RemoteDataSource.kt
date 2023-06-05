package com.erkindilekci.borutobook.domain.repository

import androidx.paging.PagingData
import com.erkindilekci.borutobook.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    fun getAllHeroes(): Flow<PagingData<Hero>>

    fun searchAllHeroes(query: String): Flow<PagingData<Hero>>
}
