package com.erkindilekci.borutobook.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.erkindilekci.borutobook.data.data_source.local.HeroDatabase
import com.erkindilekci.borutobook.data.data_source.remote.BorutoBookApi
import com.erkindilekci.borutobook.data.paging_source.HeroRemoteMediator
import com.erkindilekci.borutobook.domain.model.Hero
import com.erkindilekci.borutobook.domain.repository.RemoteDataSourceRepository
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class RemoteDataSourceRepositoryImpl(
    private val api: BorutoBookApi,
    private val db: HeroDatabase
) : RemoteDataSourceRepository {

    private val heroDao = db.heroDao()

    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = { heroDao.getAllHeroes() }
        return Pager(
            config = PagingConfig(pageSize = 3),
            remoteMediator = HeroRemoteMediator(api, db),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchAllHeroes(): Flow<PagingData<Hero>> {
        TODO("Not yet implemented")
    }
}
