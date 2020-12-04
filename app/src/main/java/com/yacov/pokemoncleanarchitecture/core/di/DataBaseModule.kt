package com.example.applicationpokemon.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

//@Module
//@InstallIn(ApplicationComponent::class)
//object DataBaseModule {
//    @Singleton
//    @Provides
//    fun provideRoomDataBase(
//        @ApplicationContext context: Context
//    ) =
//        Room.databaseBuilder(
//            context.applicationContext,
//            RoomDataBase::class.java,
//            "pokemon_db.db"
//        ).build()
//}
