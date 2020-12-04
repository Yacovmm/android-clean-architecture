package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.genericDataSource.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonDetails.data.model.local.PokemonRoomEntity

@Dao
interface IPokemonDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pokemon: PokemonRoomEntity)

    @Query("SELECT * FROM pokemon")
    fun observeAllSavedPokemon(): LiveData<List<PokemonRoomEntity>>
}
