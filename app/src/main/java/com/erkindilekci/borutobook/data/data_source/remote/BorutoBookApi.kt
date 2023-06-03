package com.erkindilekci.borutobook.data.data_source.remote

import com.erkindilekci.borutobook.data.data_source.remote.dto.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BorutoBookApi {

    @GET("/boruto/heroes")
    suspend fun getAllHeroes(
        @Query("page") page: Int = 1
    ): ApiResponse

    @GET("/boruto/heroes/search")
    suspend fun searchHeroes(
        @Query("name") name: String
    ): ApiResponse
}
