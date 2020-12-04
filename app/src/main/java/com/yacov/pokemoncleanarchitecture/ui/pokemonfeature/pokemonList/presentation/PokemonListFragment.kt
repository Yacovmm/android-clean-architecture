package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.presentation

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationpokemon.core.extension.toggleVisibility
import com.example.applicationpokemon.core.utils.Resource
import com.google.android.material.snackbar.Snackbar
import com.yacov.pokemoncleanarchitecture.databinding.PokemonListFragmentBinding
import com.yacov.pokemoncleanarchitecture.ui.adapters.GenericAdapter
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.entities.PokemonModelEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonListFragment : Fragment(), GenericAdapter.GenericRecylerAdapterDelegate {

    var binding: PokemonListFragmentBinding? = null

    lateinit var viewModel: PokemonListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = PokemonListFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(PokemonListViewModel::class.java)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        setupObservers()

        setupSpinner()

    }

    private fun setupSpinner() {
        val adapter = ArrayAdapter(requireContext(),
            R.layout.simple_dropdown_item_1line,
            listOf("", "A-Z", "Z-A"))
        binding?.filterSpinner?.adapter = adapter
        binding?.filterSpinner?.onItemSelectedListener = filterSpinnerListener
    }

    val filterSpinnerListener = object : AdapterView.OnItemSelectedListener{
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
            viewModel.orderBySpinner(pos)
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {}
    }

    private fun setupObservers() {
        viewModel._pokemonListLiveData.observe(viewLifecycleOwner) { resource ->
            when(resource) {
                is Resource.Error -> {
                    Snackbar.make(requireView(), resource.message!!, Snackbar.LENGTH_SHORT)
                }
                is Resource.Success -> {
                    resource.data?.let { viewModel.adapter?.submitList(it) }
                }
                is Resource.Loading -> {
                    binding?.paginationProgressBar?.toggleVisibility(true)
                }
            }
        }
    }

    private fun setupRecyclerView() {
        viewModel.adapter = GenericAdapter<PokemonModelEntity>(viewModel.diffCallback)
        viewModel.adapter?.delegate = this
        binding?.rvPokemonList?.apply {
            adapter = viewModel.adapter
            layoutManager = GridLayoutManager(activity, 2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun cellForPosition(
        adapter: GenericAdapter<*>,
        cell: RecyclerView.ViewHolder,
        position: Int
    ) {
        (cell as PokemonItemCell).apply {
            this.set(adapter.differ.currentList[position] as PokemonModelEntity)
        }
    }

    override fun cellType(
        adapter: GenericAdapter<*>,
        position: Int
    ): GenericAdapter.AdapterHolderType? {
        super.cellType(adapter, position)
        return GenericAdapter.AdapterHolderType(
            PokemonItemCell.resId,
            PokemonItemCell::class.java,
            1
        )
    }
}

val TAG = "POKEDEX"
