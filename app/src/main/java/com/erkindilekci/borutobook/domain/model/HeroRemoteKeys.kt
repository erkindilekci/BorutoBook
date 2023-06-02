package com.erkindilekci.borutobook.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.erkindilekci.borutobook.util.Constants.HERO_REMOTE_KEYS_TABLE_NAME

@Entity(tableName = HERO_REMOTE_KEYS_TABLE_NAME)
data class HeroRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?
)
