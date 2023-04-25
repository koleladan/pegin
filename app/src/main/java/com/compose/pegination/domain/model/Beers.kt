package com.compose.pegination.domain.model

import com.compose.pegination.data.remote.dto.BoilVolume
import com.compose.pegination.data.remote.dto.Ingredients
import com.compose.pegination.data.remote.dto.Method
import com.compose.pegination.data.remote.dto.Volume

data class Beers (
    val description: String,
    val first_brewed: String,
    val id: Int,
    val image_url: String,
    val name: String,
    val tagline: String,
)
