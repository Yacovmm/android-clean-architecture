package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.data

import com.example.applicationpokemon.core.utils.ResponseWrapper
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.entities.PokemonModelEntity
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.interfaces.IPokemonListRepository

class FakePokemonListRepository : IPokemonListRepository {

    private val pokemonList = mutableListOf<PokemonModelEntity>(
        PokemonModelEntity(name = "Charmander"),
        PokemonModelEntity(name = "Abomasnow"),
        PokemonModelEntity(name = "Zekrom"),
        PokemonModelEntity(name = "Zabix"),
        PokemonModelEntity(name = "Lucas"),
        PokemonModelEntity(name = "Arctozolt")
    )

    private var shouldReturnNetworkError = false

    fun setShouldReturnNetworkError(value: Boolean) {
        shouldReturnNetworkError = value
    }

    override suspend fun getPokemons(): ResponseWrapper<List<PokemonModelEntity>> {
        if (!shouldReturnNetworkError) {
            return ResponseWrapper.Success(pokemonList)
        }
        return ResponseWrapper.Error("Error")
    }

}