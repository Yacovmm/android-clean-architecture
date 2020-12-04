package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonSavedList.data

import androidx.lifecycle.LiveData
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.entities.PokemonModelEntity
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonSavedList.data.interfaces.IPokemonSavedDapHelper
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonSavedList.domain.interfaces.IPokemonSavedListRepository
import javax.inject.Inject

class PokemonSavedRepository @Inject constructor(
    private val daoHelper: IPokemonSavedDapHelper
) : IPokemonSavedListRepository {
    override fun getSavedPokemons(): LiveData<List<PokemonModelEntity>> =
        daoHelper.getSavedPokemons()
}
