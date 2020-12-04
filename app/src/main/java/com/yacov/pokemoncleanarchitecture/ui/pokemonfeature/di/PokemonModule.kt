package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.di

import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.data.PokemonListRepository
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.data.datasource.remote.IPokemonRetrofitApiService
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.data.datasource.remote.PokemonApiHelperImpl
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.data.interfaces.IPokemonApiHelper
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.interfaces.IPokemonListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class PokemonModule {

    @Singleton
    @Provides
    fun providePokemonApiService(retrofitInstance: Retrofit): IPokemonRetrofitApiService =
        retrofitInstance.create(IPokemonRetrofitApiService::class.java)

    @Singleton
    @Provides
    fun providePokemonListRepository(repository: PokemonListRepository): IPokemonListRepository =
        repository

    @Singleton
    @Provides
    fun providePokemonListApiHelper(apiHelper: PokemonApiHelperImpl): IPokemonApiHelper =
        apiHelper

}