package com.compose.pegination.data.repositoryImplementation

import com.compose.pegination.data.remote.dto.BeersDto
import com.compose.pegination.data.remote.dto.PunServices
import com.compose.pegination.domain.repositoryInterface.BeersRepository
import javax.inject.Inject

class BeersRepositoryImp @Inject constructor(
    private val punServices: PunServices
): BeersRepository {
    override suspend fun getBeers(): List<BeersDto> {
        return punServices.getBeers()
    }
}