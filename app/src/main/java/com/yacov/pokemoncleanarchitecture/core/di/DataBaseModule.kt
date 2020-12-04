package com.example.applicationpokemon.core.di

import android.content.Context
import androidx.room.Room
import com.yacov.pokemoncleanarchitecture.core.localDataSource.LocalRoomDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideRoomDataBase(
        @ApplicationContext context: Context
    ) =
        Room.databaseBuilder(
            context.applicationContext,
            LocalRoomDataBase::class.java,
            "pokemon_db.db"
        ).build()
}
