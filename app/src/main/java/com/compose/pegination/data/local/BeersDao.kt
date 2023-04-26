package com.compose.pegination.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.compose.pegination.domain.model.Beers

@Dao
interface BeersDao {

    @Upsert
    suspend fun UpsertAll(beers: List<BeersEntity>)

    @Query("SELECT * FROM beersentity")
    fun pagingSource(): PagingSource<Int, BeersEntity>

    @Query("DELETE FROM beersentity")
    suspend fun clearAll()
}