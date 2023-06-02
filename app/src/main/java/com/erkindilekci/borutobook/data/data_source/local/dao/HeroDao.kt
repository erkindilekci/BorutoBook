package com.erkindilekci.borutobook.data.data_source.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.erkindilekci.borutobook.domain.model.Hero

@Dao
interface HeroDao {

    @Query("SELECT * FROM hero_table ORDER BY id ASC")
    fun getAllHeroes(): PagingSource<Int, Hero>

    @Query("SELECT * FROM hero_table WHERE id=:heroId")
    fun getSelectedHero(heroId: Int): Hero

    @Insert(onConflict = REPLACE)
    suspend fun addHeroes(heroes: List<Hero>)

    @Query("DELETE FROM hero_table")
    suspend fun deleteAllHeroes()
}
