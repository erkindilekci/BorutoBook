package com.erkindilekci.borutobook.data.data_source.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? = null,
    val heroes: List<HeroDto> = emptyList(),
    val lastUpdated: Long? = null
)
