package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.interfaces

import com.example.applicationpokemon.core.utils.ResponseWrapper
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.entities.PokemonModelEntity

interface IPokemonListRepository {

    suspend fun getPokemons(): ResponseWrapper<List<PokemonModelEntity>>

}