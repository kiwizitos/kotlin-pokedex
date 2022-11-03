package com.kiwizitos.pokedex.domain

data class PokemonEntity(
    var num: String,
    var name: String,
    var img: String,
    var type: List<String>
)