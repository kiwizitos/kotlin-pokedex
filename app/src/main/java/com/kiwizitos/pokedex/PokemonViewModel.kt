package com.kiwizitos.pokedex

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kiwizitos.pokedex.network.PokemonApi
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit

class PokemonViewModel: ViewModel() {
    private val _pokemonList = MutableLiveData<List<PokemonEntity>>()

    val pokemonList: LiveData<List<PokemonEntity>> = _pokemonList

    fun getResponse() {
        viewModelScope.launch {
            val response = PokemonApi.retrofitService.getPokemon()
            _pokemonList.value = response.body()?.results?.map { PokemonEntity("", it.url, it.name, "", "") }
        }
    }
}