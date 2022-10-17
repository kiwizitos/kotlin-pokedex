package com.kiwizitos.pokedex

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.kiwizitos.pokedex.databinding.FragmentPokedexCardBinding

class PokedexCardFragment : Fragment() {
    private var _binding: FragmentPokedexCardBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    lateinit var adapter: PokemonAdapter


}