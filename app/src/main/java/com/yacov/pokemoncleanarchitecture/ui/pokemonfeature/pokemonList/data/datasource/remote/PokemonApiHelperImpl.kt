package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.data.datasource.remote

import com.example.applicationpokemon.core.utils.ResponseWrapper
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.data.interfaces.IPokemonApiHelper
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.data.model.remote.PokemonRemoteResponse
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.entities.PokemonModelEntity
import retrofit2.Response
import javax.inject.Inject

class PokemonApiHelperImpl @Inject constructor(
    private val apiService: IPokemonRetrofitApiService
) : IPokemonApiHelper {

    override suspend fun getPokemon(limit: String): ResponseWrapper<List<PokemonModelEntity>> {
        return handleGetPokemon(apiService.getPokemonList(limit))
    }

    override suspend fun handleGetPokemon(response: Any): ResponseWrapper<List<PokemonModelEntity>> {
        (response as Response<*>).let { response ->
            if (response.isSuccessful) {
                response.body()?.let { result ->
                    (result as PokemonRemoteResponse).also {
                        val entities = PokemonModelEntity.mapper(it)
                        return ResponseWrapper.Success(entities, response.code())
                    }
                }
            }
            return ResponseWrapper.Error(
                message = response.message(),
                status = response.code()
            )
        }
    }
}
