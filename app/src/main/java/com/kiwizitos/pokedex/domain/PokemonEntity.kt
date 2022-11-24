package com.kiwizitos.pokedex.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonEntity(
    var num: String,
    var name: String,
    var img: String,
    var type: List<String>,
    var height: String,
    var weight: String,
    var weaknesses: List<String>,
    var evolutions: List<Evolution>,
) : Parcelable {
    @Parcelize
    data class Evolution(
        var num: String,
        var name: String,
        var isNext: Boolean
    ) : Parcelable
}