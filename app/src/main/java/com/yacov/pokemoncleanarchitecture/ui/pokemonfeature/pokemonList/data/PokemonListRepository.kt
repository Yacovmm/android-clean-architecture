package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.data

import com.example.applicationpokemon.core.utils.ResponseWrapper
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.data.interfaces.IPokemonApiHelper
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.entities.PokemonModelEntity
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.interfaces.IPokemonListRepository
import javax.inject.Inject

class PokemonListRepository @Inject constructor(
    private val apiHelperImpl: IPokemonApiHelper
) : IPokemonListRepository {

    override suspend fun getPokemons(): ResponseWrapper<List<PokemonModelEntity>> =
        apiHelperImpl.getPokemon()

}