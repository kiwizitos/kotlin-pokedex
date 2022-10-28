package com.kiwizitos.pokedex.presentor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.kiwizitos.pokedex.databinding.FragmentPokedexCardBinding

class PokedexCardFragment: Fragment() {
    private var _binding: FragmentPokedexCardBinding? = null
    private val binding get() = _binding!!

    private val args: PokedexCardFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokedexCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val number = args.pokemonNumber
        val name = args.pokemonName
        val image = args.pokemonImage

        binding.pokemonName.text = name
        binding.pokemonNumber.text = number
        binding.pokemonImage.load(image)
    }
}