package com.kiwizitos.pokedex.presentor

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.kiwizitos.pokedex.PokemonColorUtil
import com.kiwizitos.pokedex.databinding.FragmentPokedexCardBinding

class PokedexCardFragment : Fragment() {
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
        val type = args.pokemonType

        binding.pokemonName.text = name
        binding.pokemonNumber.text = number
        binding.pokemonImage.load(image)

        type.getOrNull(0).let {
            binding.pokemonType.text = it.toString()
            binding.pokemonType.isVisible = it != null
        }
        type.getOrNull(1).let {
            binding.pokemonType2.text = it.toString()
            binding.pokemonType2.isVisible = it != null
        }
        type.getOrNull(2).let {
            binding.pokemonType3.text = it.toString()
            binding.pokemonType3.isVisible = it != null
        }

//        (activity as AppCompatActivity).supportActionBar?.title = null
//
//        val color = PokemonColorUtil(context).getPokemonColor(type.toList())
//        (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(ColorDrawable(color))

    }
}