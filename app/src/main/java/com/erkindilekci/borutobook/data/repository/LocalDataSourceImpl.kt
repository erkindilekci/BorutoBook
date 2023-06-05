package com.erkindilekci.borutobook.data.repository

import com.erkindilekci.borutobook.data.data_source.local.HeroDatabase
import com.erkindilekci.borutobook.domain.model.Hero
import com.erkindilekci.borutobook.domain.repository.LocalDataSource

class LocalDataSourceImpl(
    db: HeroDatabase
) : LocalDataSource {

    private val heroDao = db.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero {
        return heroDao.getSelectedHero(heroId)
    }
}
