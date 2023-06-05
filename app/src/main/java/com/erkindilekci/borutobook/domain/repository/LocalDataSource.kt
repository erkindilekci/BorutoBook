package com.erkindilekci.borutobook.domain.repository

import com.erkindilekci.borutobook.domain.model.Hero

interface LocalDataSource {

    suspend fun getSelectedHero(heroId: Int): Hero
}
