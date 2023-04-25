package com.compose.pegination.domain.repositoryInterface

import com.compose.pegination.data.remote.dto.BeersDto


interface BeersRepository {
    suspend fun getBeers():List<BeersDto>
}