package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.* // ktlint-disable no-wildcard-imports
import androidx.recyclerview.widget.DiffUtil
import com.example.applicationpokemon.core.utils.ResponseWrapper
import com.example.applicationpokemon.core.utils.ViewState
import com.yacov.pokemoncleanarchitecture.ui.adapters.GenericAdapter
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.entities.PokemonModelEntity
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.interfaces.IPokemonListRepository
import kotlinx.coroutines.launch

class PokemonListViewModel @ViewModelInject constructor(
    private val repository: IPokemonListRepository
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

    private var pokemonListLiveData = MutableLiveData<ViewState<List<PokemonModelEntity>>>()
    val _pokemonListLiveData: LiveData<ViewState<List<PokemonModelEntity>>> // = pokemonListLiveData
        get() = Transformations.switchMap(selectedOrder) { pos ->
            when (pos) {
                1 -> {
                    // A-Z
                    pokemonListLiveData.map {
                        val sortedList = it?.data?.sortedBy { it.name }
                        ViewState.Success(sortedList)
                    } as LiveData<ViewState<List<PokemonModelEntity>>>
                }
                2 -> {
                    pokemonListLiveData.map {
                        val sortedList = it?.data?.sortedBy { it.name }
                        ViewState.Success(sortedList)
                    } as LiveData<ViewState<List<PokemonModelEntity>>>
                }
                else -> pokemonListLiveData
            }
        }

    private fun getPokemons(limit: String = "1110") = viewModelScope.launch {
        pokemonListLiveData.postValue(ViewState.Loading())
        val response = repository.getPokemons()
        when (response) {
            is ResponseWrapper.Success -> {
                response.result?.let {
                    pokemonListLiveData.postValue(
                        ViewState.Success(it)
                    )
                }
            }
            is ResponseWrapper.Error -> {
                pokemonListLiveData.postValue(
                    response.message?.let { ViewState.Error(message = it) }
                )
            }
        }
    }

    val selectedOrder = MutableLiveData<Int>()

    fun orderBySpinner(pos: Int) {
        selectedOrder.postValue(pos)
    }

    init {
        getPokemons()
    }
}
