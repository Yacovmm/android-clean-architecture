package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonSavedList.presenation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import com.yacov.pokemoncleanarchitecture.ui.adapters.GenericAdapter
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.entities.PokemonModelEntity
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonSavedList.domain.interfaces.IPokemonSavedListRepository

class PokemonSavedListViewModel @ViewModelInject constructor(
    private val repository: IPokemonSavedListRepository
) : ViewModel() {

    var adapter: GenericAdapter<PokemonModelEntity>? = null

    val diffCallback = object : DiffUtil.ItemCallback<PokemonModelEntity>() {
        override fun areItemsTheSame(
            oldItem: PokemonModelEntity,
            newItem: PokemonModelEntity
        ): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(
            oldItem: PokemonModelEntity,
            newItem: PokemonModelEntity
        ): Boolean =
            oldItem.hashCode() == newItem.hashCode()
    }

    private var pokemonListLiveData = MutableLiveData<List<PokemonModelEntity>>()
    val _pokemonListLiveData: LiveData<List<PokemonModelEntity>> = repository.getSavedPokemons()

//    fun getPokemons() = repository.getSavedPokemons()
//
//    init {
//        getPokemons()
//    }
}
