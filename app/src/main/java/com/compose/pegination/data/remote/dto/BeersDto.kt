package com.compose.pegination.data.remote.dto

import com.compose.pegination.domain.model.Beers

data class BeersDto(
    val description: String,
    val first_brewed: String,
    val id: Int,
    val image_url: String,
    val name: String,
    val tagline: String,
)
//fun BeersDto.toBeers(): Beers {
//    return Beers(
//        id = id,
//        name = name,
//        first_brewed = first_brewed,
//        image_url = image_url,
//        description = description,
//        tagline = tagline
//    )
//}