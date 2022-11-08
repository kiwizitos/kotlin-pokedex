package com.kiwizitos.pokedex.presentor

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.google.android.material.internal.ContextUtils.getActivity
import com.kiwizitos.pokedex.MainActivity
import com.kiwizitos.pokedex.PokemonColorUtil
import com.kiwizitos.pokedex.R
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
        val pokemonDetails = args.pokemonDetails

        binding.pokemonName.text = pokemonDetails.name
        binding.pokemonNumber.text = pokemonDetails.num
        binding.pokemonImage.load(pokemonDetails.img)

        pokemonDetails.type.getOrNull(0).let {
            binding.pokemonType.text = it.toString()
            binding.pokemonType.isVisible = it != null
        }
        pokemonDetails.type.getOrNull(1).let {
            binding.pokemonType2.text = it.toString()
            binding.pokemonType2.isVisible = it != null
        }
        pokemonDetails.type.getOrNull(2).let {
            binding.pokemonType3.text = it.toString()
            binding.pokemonType3.isVisible = it != null
        }

        val color = PokemonColorUtil(context).getPokemonColor(pokemonDetails.type.toList())
        binding.detailBackground.setBackgroundColor(color)

        requireActivity().window.statusBarColor = color

        (activity as AppCompatActivity).supportActionBar?.title = ""
        (activity as AppCompatActivity).supportActionBar?.elevation = 0F
        (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(ColorDrawable(color))
    }
}