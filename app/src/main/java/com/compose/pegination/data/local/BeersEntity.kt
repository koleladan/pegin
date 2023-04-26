package com.compose.pegination.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.compose.pegination.data.remote.dto.*
import com.compose.pegination.domain.model.Beers

@Entity
data class BeersEntity(

    val description: String,
    val first_brewed: String,
    @PrimaryKey val id: Int,
    val image_url: String,
    val name: String,
    val tagline: String,
)
//dto mapper
fun BeersDto.toBeersEntity(): BeersEntity {
    return BeersEntity(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        image_url = image_url,
        first_brewed = first_brewed,


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
