package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonSavedList.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.genericDataSource.local.IPokemonDetailsDao
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.entities.PokemonModelEntity
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonSavedList.data.interfaces.IPokemonSavedDapHelper
import javax.inject.Inject

class PokemonSavedDaoHelperImpl @Inject constructor(
    private val dao: IPokemonDetailsDao
) : IPokemonSavedDapHelper {
    override fun getSavedPokemons(): LiveData<List<PokemonModelEntity>> {
        return dao.observeAllSavedPokemon().switchMap {
            val liveData = MutableLiveData<List<PokemonModelEntity>>()
            val entities = PokemonModelEntity.mapper(it)
            liveData.postValue(entities)
            liveData
        }
    }
}
