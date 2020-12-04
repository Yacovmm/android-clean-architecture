package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonDetails.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.entities.PokemonModelEntity
import java.io.Serializable

@Entity(
    tableName = "pokemon"
)
data class PokemonRoomEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val name: String,
    val url: String?,
    var image: String?

) : Serializable {
    companion object {
        fun mapper(pokemonModelEntity: PokemonModelEntity) = PokemonRoomEntity(
            name = pokemonModelEntity.name ?: "",
            url = pokemonModelEntity.url,
            image = pokemonModelEntity.image
        )
    }
}
