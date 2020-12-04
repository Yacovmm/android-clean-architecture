package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.entities

import com.example.applicationpokemon.core.utils.Constants
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonDetails.data.model.local.PokemonRoomEntity
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.data.model.remote.PokemonRemoteModel
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.data.model.remote.PokemonRemoteResponse
import java.io.Serializable

data class PokemonModelEntity(
    var id: Int? = null,
    var name: String? = null,
    var image: String? = null,
    var url: String? = null,
) : Serializable {

    companion object {
        fun mapper(pokemonRemoteModel: PokemonRemoteModel) = PokemonModelEntity(
            id = null,
            name = pokemonRemoteModel.name,
            image = pokemonRemoteModel.image,
            url = "${Constants.URL_IMG}${pokemonRemoteModel.url.substring(
                34,
                pokemonRemoteModel.url.length - 1
            )}.png"
        )

        fun mapper(pokemonRemoteResponse: PokemonRemoteResponse): List<PokemonModelEntity> =
            pokemonRemoteResponse.results.map {
                mapper(it)
            }

        fun mapper(pokemonRoomEntity: PokemonRoomEntity) = PokemonModelEntity(
            id = pokemonRoomEntity.id,
            name = pokemonRoomEntity.name,
            image = pokemonRoomEntity.image,
            url = pokemonRoomEntity.url
        )

        fun mapper(pokemonRoomEntity: List<PokemonRoomEntity>) =
            pokemonRoomEntity.map { mapper(it) }
    }
}
