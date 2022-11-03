package com.kiwizitos.pokedex.presentor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kiwizitos.pokedex.domain.PokemonEntity
import com.kiwizitos.pokedex.network.PokemonApi
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {
    private val _pokemonList = MutableLiveData<List<PokemonEntity>>()
    val pokemonList: LiveData<List<PokemonEntity>> = _pokemonList

    fun getResponse() {
        viewModelScope.launch {
            val response = PokemonApi.retrofitService.getPokemon()
            _pokemonList.value = response.body()?.pokemon?.map {
                PokemonEntity(
                    num = it.num,
                    name = it.name,
                    img = it.img,
                    type = it.type!!
                )
            }
        }
    }
}