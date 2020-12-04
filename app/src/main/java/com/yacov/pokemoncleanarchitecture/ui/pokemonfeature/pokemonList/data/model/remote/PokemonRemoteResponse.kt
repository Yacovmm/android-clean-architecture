package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.data.model.remote

import java.io.Serializable

data class PokemonRemoteResponse(
    val results: MutableList<PokemonRemoteModel>
) : Serializable

data class PokemonRemoteModel(
    val name: String,
    val url: String,
    var image: String
) : Serializable
