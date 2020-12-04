package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonDetails.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonDetails.domain.interfaces.IPokemonDetailsRepository
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.entities.PokemonModelEntity
import kotlinx.coroutines.launch

class PokemonDetailsViewModel @ViewModelInject constructor(
    private val repository: IPokemonDetailsRepository
) : ViewModel() {

    fun savePokemon() = viewModelScope.launch {
        pokemon?.let {
            repository.savePokemon(it)
        }
    }

    var pokemon: PokemonModelEntity? = null
}
