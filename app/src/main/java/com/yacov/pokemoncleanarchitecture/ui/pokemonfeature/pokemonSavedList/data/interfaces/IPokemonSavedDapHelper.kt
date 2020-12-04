package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonSavedList.data.interfaces

import androidx.lifecycle.LiveData
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.entities.PokemonModelEntity

interface IPokemonSavedDapHelper {
    fun getSavedPokemons(): LiveData<List<PokemonModelEntity>>
}
