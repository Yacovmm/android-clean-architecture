package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonSavedList.domain.interfaces

import androidx.lifecycle.LiveData
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.entities.PokemonModelEntity

interface IPokemonSavedListRepository {

    fun getSavedPokemons(): LiveData<List<PokemonModelEntity>>
}
