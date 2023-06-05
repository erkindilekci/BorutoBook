package com.erkindilekci.borutobook.data.paging_source

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingConfig
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.paging.RemoteMediator.MediatorResult.Success
import androidx.test.core.app.ApplicationProvider
import com.erkindilekci.borutobook.data.data_source.local.HeroDatabase
import com.erkindilekci.borutobook.data.data_source.remote.FakeBorutoBookApi2
import com.erkindilekci.borutobook.domain.model.Hero
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HeroRemoteMediatorTest {

    private lateinit var borutoBookApi: FakeBorutoBookApi2
    private lateinit var heroDatabase: HeroDatabase

    @Before
    fun setup() {
        borutoBookApi = FakeBorutoBookApi2()
        heroDatabase = HeroDatabase.create(
            context = ApplicationProvider.getApplicationContext(),
            useInMemory = true
        )
    }

    @After
    fun teardown() {
        heroDatabase.clearAllTables()
    }

    @OptIn(ExperimentalPagingApi::class)
    @Test
    fun test_refreshLoad_ReturnsSuccessResult_WhenMoreDataIsPresent() = runBlocking {
        val remoteMediator = HeroRemoteMediator(
            api = borutoBookApi,
            db = heroDatabase
        )
        val pagingState = PagingState<Int, Hero>(
            pages = emptyList(),
            anchorPosition = null,
            config = PagingConfig(pageSize = 3),
            leadingPlaceholderCount = 0
        )
        val result = remoteMediator.load(LoadType.REFRESH, pagingState)

        assertTrue(result is Success)
        assertFalse((result as Success).endOfPaginationReached)
    }

    @OptIn(ExperimentalPagingApi::class)
    @Test
    fun test_refreshLoadSuccess_AndEndOfPaginationTrue_WhenNoMoreData() = runBlocking {
        borutoBookApi.clearData()
        val remoteMediator = HeroRemoteMediator(
            api = borutoBookApi,
            db = heroDatabase
        )
        val pagingState = PagingState<Int, Hero>(
            pages = listOf(),
            anchorPosition = null,
            config = PagingConfig(pageSize = 3),
            leadingPlaceholderCount = 0
        )
        val result = remoteMediator.load(LoadType.REFRESH, pagingState)
        assertTrue(result is Success)
        assertTrue((result as Success).endOfPaginationReached)
    }

    @OptIn(ExperimentalPagingApi::class)
    @Test
    fun test_refreshLoad_ReturnsError_WhenErrorOccurs() = runBlocking {
        borutoBookApi.addException()
        val remoteMediator = HeroRemoteMediator(
            api = borutoBookApi,
            db = heroDatabase
        )
        val pagingState = PagingState<Int, Hero>(
            pages = listOf(),
            anchorPosition = null,
            config = PagingConfig(pageSize = 3),
            leadingPlaceholderCount = 0
        )
        val result = remoteMediator.load(LoadType.REFRESH, pagingState)
        assertTrue(result is RemoteMediator.MediatorResult.Error)
    }
}
