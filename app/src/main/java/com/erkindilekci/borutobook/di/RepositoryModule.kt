package com.erkindilekci.borutobook.di

import android.content.Context
import com.erkindilekci.borutobook.data.repository.BorutoBookRepository
import com.erkindilekci.borutobook.data.repository.DataStoreRepositoryImpl
import com.erkindilekci.borutobook.domain.repository.DataStoreRepository
import com.erkindilekci.borutobook.domain.use_cases.UseCases
import com.erkindilekci.borutobook.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.erkindilekci.borutobook.domain.use_cases.get_selected_hero.GetSelectedHeroUseCase
import com.erkindilekci.borutobook.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.erkindilekci.borutobook.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import com.erkindilekci.borutobook.domain.use_cases.search_heroes.SearchHeroesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreRepository(
        @ApplicationContext context: Context
    ): DataStoreRepository = DataStoreRepositoryImpl(context)

    @Provides
    @Singleton
    fun provideUseCases(repository: BorutoBookRepository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository),
            getAllHeroesUseCase = GetAllHeroesUseCase(repository),
            searchHeroesUseCase = SearchHeroesUseCase(repository),
            getSelectedHeroUseCase = GetSelectedHeroUseCase(repository)
        )
    }
}
