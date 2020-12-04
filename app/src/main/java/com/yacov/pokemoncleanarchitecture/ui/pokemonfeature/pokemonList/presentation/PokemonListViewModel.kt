package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.recyclerview.widget.DiffUtil
import com.example.applicationpokemon.core.utils.Resource
import com.example.applicationpokemon.core.utils.ResponseWrapper
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

    private var pokemonListLiveData = MutableLiveData<Resource<List<PokemonModelEntity>>>()
    val _pokemonListLiveData: LiveData<Resource<List<PokemonModelEntity>>> = pokemonListLiveData
//        get() = Transformations.switchMap(selectedOrder) { pos ->
//            when(pos) {
//                1 -> {
//                    //A-Z
//                    pokemonListLiveData.map {
//                        val sortedList = it?.data?.sortedBy { it.name }
//                        Resource.Success(sortedList)
//                    }  as LiveData<Resource<List<PokemonModelEntity>>>
//                }
//                2 -> {
//                    pokemonListLiveData.map {
//                        val sortedList = it?.data?.sortedBy { it.name }
//                        Resource.Success(sortedList)
//                    }  as LiveData<Resource<List<PokemonModelEntity>>>
//                }
//                else -> pokemonListLiveData
//            }
//        }

    fun getPokemons(limit: String = "1110") = viewModelScope.launch {
        pokemonListLiveData.postValue(Resource.Loading())
        val response = repository.getPokemons()
        when(response) {
            is ResponseWrapper.Success -> {
                response.result?.let {
                    pokemonListLiveData.postValue(
                        Resource.Success(it)
                    )
                }
            }
            is ResponseWrapper.Error -> {
                pokemonListLiveData.postValue(
                    response.message?.let { Resource.Error(message = it) }
                )
            }
        }
    }

    val selectedOrder = MutableLiveData<Int>()

    fun orderBySpinner(pos: Int) {
        println(pos)
        selectedOrder.postValue(pos)
//        val sortedLiveData = Transformations.switchMap(pokemonListLiveData) { resource ->
//            val sortedLivadata = MutableLiveData<Resource<List<PokemonModelEntity>>>()
//            val sortedLiveData = when (pos) {
//                1 -> {
//                    // A-Z
//                    val sorted = resource.data?.sortedBy { it.name }
//                    sortedLivadata.value = Resource.Success(data = sorted!!)
//                    sortedLivadata
//                }
//                2 -> {
//                    // Z Y
//                    val sorted = resource.data?.sortedByDescending { it.name }
//                    sortedLivadata.value = Resource.Success(data = sorted!!)
//                    sortedLivadata
//                }
//                else -> pokemonListLiveData
//            }
//            sortedLiveData
//        }
//
//        pokemonListLiveData.value = sortedLiveData.value
    }

    init {
        getPokemons()
    }

}