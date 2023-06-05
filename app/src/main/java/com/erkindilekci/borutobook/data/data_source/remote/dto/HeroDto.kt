package com.erkindilekci.borutobook.data.data_source.remote.dto

import com.erkindilekci.borutobook.domain.model.Hero
import kotlinx.serialization.Serializable

@Serializable
data class HeroDto(
    val id: Int,
    val name: String,
    val image: String,
    val about: String,
    val rating: Double,
    val power: Int,
    val month: String,
    val day: String,
    val family: List<String>,
    val abilities: List<String>,
    val natureTypes: List<String>
) {
    fun toHero(): Hero =
        Hero(id, name, image, about, rating, power, month, day, family, abilities, natureTypes)
}

fun Hero.toHeroDto(): HeroDto =
    HeroDto(id, name, image, about, rating, power, month, day, family, abilities, natureTypes)
