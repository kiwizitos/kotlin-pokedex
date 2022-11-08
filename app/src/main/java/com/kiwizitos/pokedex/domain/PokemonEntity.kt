package com.kiwizitos.pokedex.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonEntity(
    var num: String,
    var name: String,
    var img: String,
    var type: List<String>
) : Parcelable