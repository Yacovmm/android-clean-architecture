package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonSavedList.presenation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yacov.pokemoncleanarchitecture.databinding.PokemonListFragmentBinding
import com.yacov.pokemoncleanarchitecture.ui.adapters.GenericAdapter
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.entities.PokemonModelEntity
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.presentation.PokemonItemCell
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonSavedListFragment : Fragment(), GenericAdapter.GenericRecylerAdapterDelegate {

    var binding: PokemonListFragmentBinding? = null

    lateinit var viewModel: PokemonSavedListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = PokemonListFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(PokemonSavedListViewModel::class.java)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        setupObservers()
    }

    private fun setupObservers() {
        viewModel._pokemonListLiveData.observe(viewLifecycleOwner) { result ->
            viewModel.adapter?.submitList(result)
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

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
