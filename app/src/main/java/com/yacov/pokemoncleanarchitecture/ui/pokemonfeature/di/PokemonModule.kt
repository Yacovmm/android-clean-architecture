package com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.di

import com.yacov.pokemoncleanarchitecture.core.localDataSource.LocalRoomDataBase
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.genericDataSource.local.IPokemonDetailsDao
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonDetails.data.PokemonDetailsRepository
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonDetails.data.datasource.local.PokemonDetailsDaoHelperImpl
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonDetails.data.interfaces.IPokemonDetailsDaoHelper
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonDetails.domain.interfaces.IPokemonDetailsRepository
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.data.PokemonListRepository
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.data.datasource.remote.IPokemonRetrofitApiService
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.data.datasource.remote.PokemonApiHelperImpl
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.data.interfaces.IPokemonApiHelper
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonList.domain.interfaces.IPokemonListRepository
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonSavedList.data.PokemonSavedRepository
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonSavedList.data.interfaces.IPokemonSavedDapHelper
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonSavedList.data.local.PokemonSavedDaoHelperImpl
import com.yacov.pokemoncleanarchitecture.ui.pokemonfeature.pokemonSavedList.domain.interfaces.IPokemonSavedListRepository
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

    @Singleton
    @Provides
    fun providePokemonDetailsDaoRoom(database: LocalRoomDataBase): IPokemonDetailsDao =
        database.getPokemonDetailsDao()

    @Singleton
    @Provides
    fun providePokemonDetailsDaoHelper(daoHelper: PokemonDetailsDaoHelperImpl): IPokemonDetailsDaoHelper =
        daoHelper

    @Singleton
    @Provides
    fun providePokemonDetailsRepository(repository: PokemonDetailsRepository):
        IPokemonDetailsRepository = repository

    @Singleton
    @Provides
    fun providePokemonSavedDaoHelper(daoHelper: PokemonSavedDaoHelperImpl): IPokemonSavedDapHelper =
        daoHelper

    @Singleton
    @Provides
    fun providePokemonSavedRepository(repository: PokemonSavedRepository):
        IPokemonSavedListRepository = repository
}
