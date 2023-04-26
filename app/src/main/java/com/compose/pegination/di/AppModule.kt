package com.compose.pegination.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.compose.pegination.data.local.BeersDatabase
import com.compose.pegination.data.local.BeersEntity
import com.compose.pegination.data.remote.dto.BeersRemoteMediator
import com.compose.pegination.data.remote.dto.PunServices
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBeerDatabase(@ApplicationContext context: Context): BeersDatabase {
        return  Room.databaseBuilder(
            context,
            BeersDatabase::class.java,
            "beers.db"
        ).build()
    }
    @Provides
    @Singleton
    fun provideBeerApi(): PunServices {

         val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()


        return Retrofit.Builder()
            .baseUrl(PunServices.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create()
    }

    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun provideBeerPager(beersDb: BeersDatabase, punServices: PunServices):Pager<Int, BeersEntity> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = BeersRemoteMediator(
                beersDb = beersDb,
                punServices = punServices
            ),
            pagingSourceFactory = {
                beersDb.dao.pagingSource()

            }

        )
    }
}