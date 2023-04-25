package com.compose.pegination.data.remote.dto

import com.compose.pegination.domain.model.Beers

data class BeersDto(
    val abv: Double,
    val attenuation_level: Int,
    val boil_volume: BoilVolume,
    val brewers_tips: String,
    val contributed_by: String,
    val description: String,
    val ebc: Int,
    val first_brewed: String,
    val food_pairing: List<String>,
    val ibu: Int,
    val id: Int,
    val image_url: String,
    val ingredients: Ingredients,
    val method: Method,
    val name: String,
    val ph: Double,
    val srm: Int,
    val tagline: String,
    val target_fg: Int,
    val target_og: Int,
    val volume: Volume
)
fun BeersDto.toBeers(): Beers {
    return Beers(
        id = id,
        name = name,
        first_brewed = first_brewed,
        image_url = image_url,
        description = description,
        tagline = tagline
    )
}