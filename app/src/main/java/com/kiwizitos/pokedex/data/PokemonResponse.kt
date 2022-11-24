package com.kiwizitos.pokedex.data

data class PokemonResponse(
    val name: String,
    val num: String,
    val img: String,
    val type: List<String>?,
    val height: String,
    val weight: String,
    val weaknesses: List<String>,
    val prev_evolution: List<Evolution>?,
    val next_evolution: List<Evolution>?
) {
    data class Evolution(
        var num: String,
        var name: String
    )
}