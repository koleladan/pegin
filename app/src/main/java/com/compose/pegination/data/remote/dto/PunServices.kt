package com.compose.pegination.data.remote.dto

import retrofit2.http.GET
import retrofit2.http.Query

interface PunServices {
    @GET("beers")
    suspend fun getBeers(
        //To support pagination
    @Query("page") page: Int,
    @Query("per_page") pageCount: Int
    ): List<BeersDto>

    companion object {
        const val BASE_URL = "https://api.punkapi.com/v2/"
    }
}