package com.kiwizitos.pokedex.presentor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.kiwizitos.pokedex.databinding.FragmentAttributesBinding
import com.kiwizitos.pokedex.domain.PokemonEntity

class AttributesFragment : Fragment() {
    private var _binding: FragmentAttributesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAttributesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelable<PokemonEntity>(DescriptionFragment.data)?.let {
            binding.pokemonHeight.text = it.height
            binding.pokemonWeight.text = it.weight
        }
    }

    companion object {
        const val data = "data"
        fun newInstance(dataValue: PokemonEntity): Fragment{
            val args = bundleOf(
                data to dataValue
            )

            val fragment = AttributesFragment()
            fragment.arguments = args
            return fragment
        }
    }
}