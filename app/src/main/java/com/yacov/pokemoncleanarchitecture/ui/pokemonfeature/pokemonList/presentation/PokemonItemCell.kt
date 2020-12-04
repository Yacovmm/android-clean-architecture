package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.yacov.pokemoncleanarchitecture.R
import com.yacov.pokemoncleanarchitecture.ui.genericView.BaseCell
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.entities.PokemonModelEntity

class PokemonItemCell(view: View) : BaseCell(view) {

    companion object {
        val resId: Int = R.layout.pokemon_item_cell
    }

    val nameTv = view.findViewById<TextView>(R.id.item_pokemon_txt_name)
    val imageIv = view.findViewById<ImageView>(R.id.item_pokemon_img)

    fun set(model: PokemonModelEntity) {
        nameTv.text = model.name
        imageIv.load(model.url)
    }

}