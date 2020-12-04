package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.androiddevs.shoppinglisttestingyt.MainCoroutineRule
import com.androiddevs.shoppinglisttestingyt.getOrAwaitValueTest
import com.google.common.truth.Truth.assertThat
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.data.FakePokemonListRepository
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.entities.PokemonModelEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before

import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class PokemonListViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: PokemonListViewModel

    @Before
    fun setUp() {
        viewModel = PokemonListViewModel(FakePokemonListRepository())
    }

    @Test
    fun `order items by A-Z, index 1, pokemons should be ordered`() {
        viewModel.orderBySpinner(1)
        val items = viewModel._pokemonListLiveData.getOrAwaitValueTest()

        assertThat(items.data!![0].name).isEqualTo("Abomasnow")
        assertThat(items.data!!.last().name).isEqualTo("Zekrom")
    }

    @Test
    fun `order items by nothing, index 0 should return the normal list`() {
        viewModel.orderBySpinner(0)
        val items = viewModel._pokemonListLiveData.getOrAwaitValueTest()

        assertThat(items.data!![0].name).isEqualTo("Charmander")
        assertThat(items.data!!.last().name).isEqualTo("Arctozolt")
    }

    @Test
    fun `order items Z-A, index 2, should return the reversed list`() {
        viewModel.orderBySpinner(2)
        val items = viewModel._pokemonListLiveData.getOrAwaitValueTest()

        assertThat(items.data!![0].name).isEqualTo("Zekrom")
        assertThat(items.data!!.last().name).isEqualTo("Abomasnow")
    }


}