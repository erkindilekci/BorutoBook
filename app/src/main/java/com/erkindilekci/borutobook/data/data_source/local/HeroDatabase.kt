package com.erkindilekci.borutobook.data.data_source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.erkindilekci.borutobook.data.data_source.local.dao.HeroDao
import com.erkindilekci.borutobook.data.data_source.local.dao.HeroRemoteKeysDao
import com.erkindilekci.borutobook.domain.model.Hero
import com.erkindilekci.borutobook.domain.model.HeroRemoteKeys

@Database(entities = [Hero::class, HeroRemoteKeys::class], version = 1, exportSchema = false)
@TypeConverters(DatabaseConverter::class)
abstract class HeroDatabase : RoomDatabase() {

    companion object {
        fun create(context: Context, useInMemory: Boolean): HeroDatabase {
            val databaseBuilder = if (useInMemory) {
                Room.inMemoryDatabaseBuilder(context, HeroDatabase::class.java)
            } else {
                Room.databaseBuilder(context, HeroDatabase::class.java, "test_database.db")
            }
            return databaseBuilder
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeysDao(): HeroRemoteKeysDao
}
