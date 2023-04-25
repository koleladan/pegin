package com.compose.pegination.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [BeersEntity::class],
    version = 1
)
abstract class BeersDatabase: RoomDatabase() {
    abstract val dao: BeersDao
}