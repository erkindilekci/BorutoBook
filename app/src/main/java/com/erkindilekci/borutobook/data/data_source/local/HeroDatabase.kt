package com.erkindilekci.borutobook.data.data_source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.erkindilekci.borutobook.data.data_source.local.dao.HeroDao
import com.erkindilekci.borutobook.data.data_source.local.dao.HeroRemoteKeysDao
import com.erkindilekci.borutobook.domain.model.Hero
import com.erkindilekci.borutobook.domain.model.HeroRemoteKeys

@Database(entities = [Hero::class, HeroRemoteKeys::class], version = 1, exportSchema = false)
@TypeConverters(DatabaseConverter::class)
abstract class HeroDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeysDao(): HeroRemoteKeysDao
}
