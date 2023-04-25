package com.compose.pegination.data.local

import androidx.room.PrimaryKey
import com.compose.pegination.data.remote.dto.*
import com.compose.pegination.domain.model.Beers


data class BeersEntity(
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
    @PrimaryKey val id: Int,
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
//dto mapper
fun BeersDto.toBeerEntity(): BeersEntity {
    return BeersEntity(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        image_url = image_url,
        first_brewed = first_brewed,
        volume = volume,
        target_fg = target_fg,
        target_og = target_og,
        srm = srm,
        ph = ph,
        method = method,
        ingredients = ingredients,
        ibu = ibu,
        food_pairing = food_pairing,
        ebc = ebc,
        contributed_by = contributed_by,
        brewers_tips = brewers_tips,
        boil_volume = boil_volume,
        attenuation_level = attenuation_level,
        abv = abv

    )
}
//entity mapper
fun BeersEntity. toBeers(): Beers {
    return Beers(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        image_url = image_url,
        first_brewed = first_brewed,

    )
}
