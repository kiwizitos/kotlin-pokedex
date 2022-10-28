package com.kiwizitos.pokedex.network

import com.kiwizitos.pokedex.data.PokemonListResponse
import com.kiwizitos.pokedex.data.PokemonResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl("https://raw.githubusercontent.com/Biuni/PokemonGO-Pokedex/master/")
    .build()

interface PokemonApiService {
    @GET("pokedex.json")
    suspend fun getPokemon(): Response<PokemonListResponse>
}


object PokemonApi {
    val retrofitService: PokemonApiService by lazy { retrofit.create(PokemonApiService::class.java) }
}
