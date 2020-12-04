package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonDetails.data

import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonDetails.data.interfaces.IPokemonDetailsDaoHelper
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonDetails.domain.interfaces.IPokemonDetailsRepository
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.entities.PokemonModelEntity
import javax.inject.Inject

class PokemonDetailsRepository @Inject constructor(
    private val daoHelper: IPokemonDetailsDaoHelper
) : IPokemonDetailsRepository {
    override suspend fun savePokemon(pokemon: PokemonModelEntity) {
        daoHelper.insert(pokemon)
    }
}
