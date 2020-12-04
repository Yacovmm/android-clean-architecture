package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonDetails.domain.interfaces

import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.entities.PokemonModelEntity

interface IPokemonDetailsRepository {
    suspend fun savePokemon(pokemon: PokemonModelEntity)
}
