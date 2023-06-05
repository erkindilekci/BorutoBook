package com.erkindilekci.borutobook.di

import androidx.paging.ExperimentalPagingApi
import com.erkindilekci.borutobook.data.data_source.local.HeroDatabase
import com.erkindilekci.borutobook.data.data_source.remote.BorutoBookApi
import com.erkindilekci.borutobook.data.repository.RemoteDataSourceImpl
import com.erkindilekci.borutobook.domain.repository.RemoteDataSource
import com.erkindilekci.borutobook.util.Constants.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideBorutoBookApi(
        okHttpClient: OkHttpClient
    ): BorutoBookApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(BorutoBookApi::class.java)
    }

    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun provideRemoteDataSource(
        borutoBookApi: BorutoBookApi,
        heroDatabase: HeroDatabase
    ): RemoteDataSource {
        return RemoteDataSourceImpl(borutoBookApi, heroDatabase)
    }
}
