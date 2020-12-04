package com.yacov.pokemoncleanarchitecture.core.localDataSource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.genericDataSource.local.IPokemonDetailsDao
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonDetails.data.model.local.PokemonRoomEntity

@Database(
    entities = [PokemonRoomEntity::class],
    version = 1
)
abstract class LocalRoomDataBase : RoomDatabase() {
    abstract fun getPokemonDetailsDao(): IPokemonDetailsDao
}
