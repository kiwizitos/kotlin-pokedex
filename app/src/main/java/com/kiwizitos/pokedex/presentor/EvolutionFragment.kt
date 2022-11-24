package com.kiwizitos.pokedex.presentor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.kiwizitos.pokedex.databinding.FragmentEvolutionBinding
import com.kiwizitos.pokedex.domain.PokemonEntity

class EvolutionFragment : Fragment() {
    private var _binding: FragmentEvolutionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEvolutionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<PokemonEntity>(data)?.let {
            checkEvolution(it.evolutions)
        }
    }

    private fun checkEvolution(evolutions: List<PokemonEntity.Evolution>) {
        if (evolutions.size == 1) {
            binding.nextContainer.isVisible = false
        }

        evolutions.forEachIndexed { index, evolution ->
            if (index == 0) {
                binding.containerLabel1.text = if (evolution.isNext) "Next" else "Previous"
                binding.pokemonName.text = evolution.name
                binding.pokemonNumber.text = evolution.num
            } else {
                binding.containerLabel2.text = if (evolution.isNext) "Next" else "Previous"
                binding.pokemonNextName.text = evolution.name
                binding.pokemonNextNum.text = evolution.num
            }
        }
    }

    companion object {
        const val data = "data"
        fun newInstance(dataValue: PokemonEntity): Fragment {
            val args = bundleOf(
                data to dataValue
            )

            val fragment = EvolutionFragment()
            fragment.arguments = args
            return fragment
        }
    }
}