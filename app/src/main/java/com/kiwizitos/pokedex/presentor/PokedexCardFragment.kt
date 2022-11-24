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
import com.google.android.material.tabs.TabLayoutMediator
import com.kiwizitos.pokedex.PokemonColorUtil
import com.kiwizitos.pokedex.databinding.FragmentPokedexCardBinding
import com.kiwizitos.pokedex.presentor.adapter.FragmentTabPageAdapter

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

        setupViewPager()
    }

    private val createTab: ArrayList<FragmentTabPageAdapter.PageModel>
        get() = arrayListOf(
        FragmentTabPageAdapter.PageModel(id = "weaknesses", title = "Weaknesses", fragment = DescriptionFragment.newInstance(args.pokemonDetails)),
        FragmentTabPageAdapter.PageModel(id = "attributes", title = "Attributes", fragment = AttributesFragment.newInstance(args.pokemonDetails)),
        FragmentTabPageAdapter.PageModel(id = "evolutions", title = "Evolutions", fragment = EvolutionFragment.newInstance(args.pokemonDetails)),
        )

    private fun setupViewPager() {
        val adapter = FragmentTabPageAdapter(childFragmentManager, lifecycle)
        binding.detailViewPager.adapter = adapter
        TabLayoutMediator(binding.descriptionTabLayout, binding.detailViewPager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
            binding.detailViewPager.setCurrentItem(tab.position, false)
        }.attach()
        adapter.updateData(createTab)
    }
}