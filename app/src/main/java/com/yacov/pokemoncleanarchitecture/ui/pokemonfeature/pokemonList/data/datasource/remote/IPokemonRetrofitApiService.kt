package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.data.datasource.remote

import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.data.model.remote.PokemonRemoteResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IPokemonRetrofitApiService {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: String = "1117"
    ): Response<PokemonRemoteResponse>
}
