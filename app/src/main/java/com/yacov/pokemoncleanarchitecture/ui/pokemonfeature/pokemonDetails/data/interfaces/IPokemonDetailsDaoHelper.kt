package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonDetails.data.interfaces

import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.entities.PokemonModelEntity

interface IPokemonDetailsDaoHelper {

    suspend fun insert(pokemon: PokemonModelEntity)
}
