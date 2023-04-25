package com.compose.pegination.domain.usecases

import com.compose.pegination.core.Resource
import com.compose.pegination.data.remote.dto.toBeers
import com.compose.pegination.domain.model.Beers
import com.compose.pegination.domain.repositoryInterface.BeersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class getCharactersUseCase @Inject constructor(
    private val repository: BeersRepository
) {
    operator fun invoke(): Flow<Resource<List<Beers>>> = flow {
        try {
            emit(Resource.Loading())
            val characters = repository.getBeers().map { it.toBeers() }
            emit(Resource.Success(characters))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))

        } catch (e: IOException) {
            emit(Resource.Error( "Couldn't reach the server. Check your internet connection"))

        }

    }
}