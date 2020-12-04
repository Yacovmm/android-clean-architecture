package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonDetails.data.datasource.local

import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.genericDataSource.local.IPokemonDetailsDao
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonDetails.data.interfaces.IPokemonDetailsDaoHelper
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonDetails.data.model.local.PokemonRoomEntity
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.entities.PokemonModelEntity
import javax.inject.Inject

class PokemonDetailsDaoHelperImpl @Inject constructor(
    private val pokemonDao: IPokemonDetailsDao
) : IPokemonDetailsDaoHelper {
    override suspend fun insert(pokemon: PokemonModelEntity) {
        pokemonDao.insert(PokemonRoomEntity.mapper(pokemon))
    }
}
