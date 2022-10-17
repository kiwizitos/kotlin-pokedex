package com.kiwizitos.pokedex.network

import com.kiwizitos.pokedex.PokemonResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl("https://pokeapi.co/api/v2/")
    .build()

interface PokemonApiService {
    @GET("pokemon?limit=151")
    suspend fun getPokemon(): Response<PokemonResponse>
}

object PokemonApi {
    val retrofitService: PokemonApiService by lazy { retrofit.create(PokemonApiService::class.java) }
}