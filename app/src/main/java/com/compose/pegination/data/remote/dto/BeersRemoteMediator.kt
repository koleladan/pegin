package com.compose.pegination.data.remote.dto

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.compose.pegination.data.local.BeersDatabase
import com.compose.pegination.data.local.BeersEntity
import com.compose.pegination.data.local.toBeersEntity
import kotlinx.coroutines.delay
import okio.IOException
import retrofit2.HttpException

@OptIn(ExperimentalPagingApi::class)
class BeersRemoteMediator(

    private val beersDb: BeersDatabase,
    private val punServices: PunServices

): RemoteMediator<Int, BeersEntity>() {


    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, BeersEntity>
    ): MediatorResult {
        return  try {
            val loadKey = when(loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if(lastItem == null) {
                        1
                    } else {
                        (lastItem.id/ state.config.pageSize) + 1
                    }
                }
            }
            delay(2000L)
            val beers = punServices.getBeers(
                page = loadKey,
                pageCount =  state.config.pageSize
            )
            beersDb.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    beersDb.dao.clearAll()
                }
                val beersEntity = beers.map{it.toBeersEntity()}
                beersDb.dao.UpsertAll(beersEntity)
            }

            MediatorResult.Success(
                endOfPaginationReached = beers.isEmpty()
            )

        }catch (e: HttpException) {
            MediatorResult.Error(e)

        }catch (e: IOException) {
            MediatorResult.Error(e)

        }

    }
}