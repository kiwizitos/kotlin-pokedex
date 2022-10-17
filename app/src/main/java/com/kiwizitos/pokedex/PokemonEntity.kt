package com.kiwizitos.pokedex

data class PokemonEntity(
    var id: String,
    var url: String,
    var name: String,
    var type: String,
    var image: String
) {
    companion object {
        fun mapping(response: PokemonResponse): List<PokemonEntity> {
            return response.results.map { PokemonEntity("",it.url, it.name, "", "") }
        }
    }
}