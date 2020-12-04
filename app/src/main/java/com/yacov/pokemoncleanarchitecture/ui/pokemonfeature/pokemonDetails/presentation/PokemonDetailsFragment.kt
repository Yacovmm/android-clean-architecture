package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonDetails.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import com.yacov.pokemoncleanarchitecture.databinding.PokemonDetailFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonDetailsFragment : Fragment() {

    var binding: PokemonDetailFragmentBinding? = null

    private val viewModel: PokemonDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = PokemonDetailFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.pokemon = PokemonDetailsFragmentArgs.fromBundle(requireArguments()).pokemon

        binding?.pokemonDetailFragmentImg?.load(viewModel.pokemon?.url)

        binding?.pokemonDetailFragmentTxtName?.text = viewModel.pokemon?.name

        binding?.fab?.setOnClickListener {
            viewModel.savePokemon()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
