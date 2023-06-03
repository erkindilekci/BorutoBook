package com.erkindilekci.borutobook.di

import android.content.Context
import androidx.room.Room
import com.erkindilekci.borutobook.data.data_source.local.HeroDatabase
import com.erkindilekci.borutobook.util.Constants.HERO_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): HeroDatabase = Room.databaseBuilder(
        context,
        HeroDatabase::class.java,
        HERO_DATABASE_NAME
    ).build()
}
