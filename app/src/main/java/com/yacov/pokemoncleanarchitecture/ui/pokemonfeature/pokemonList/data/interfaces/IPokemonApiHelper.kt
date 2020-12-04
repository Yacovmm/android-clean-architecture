package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.data.interfaces

import com.example.applicationpokemon.core.utils.ResponseWrapper
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.entities.PokemonModelEntity

interface IPokemonApiHelper {
    suspend fun getPokemon(limit: String = "1117"): ResponseWrapper<List<PokemonModelEntity>>
    suspend fun handleGetPokemon(response: Any): ResponseWrapper<List<PokemonModelEntity>>
}