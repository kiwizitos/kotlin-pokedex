package com.kiwizitos.pokedex.presentor

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.kiwizitos.pokedex.databinding.FragmentDescriptionBinding
import com.kiwizitos.pokedex.domain.PokemonEntity

class DescriptionFragment : Fragment() {
    private var _binding: FragmentDescriptionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getStringArrayList(data)
        arguments?.getParcelable<PokemonEntity>(data)?.let {
            binding.descriptionPokemonName.text = it.weaknesses.joinToString("\n")
        }
    }

    companion object {
        const val data = "data"
        fun newInstance(dataValue: PokemonEntity): Fragment{
            val args = bundleOf(
                data to dataValue
            )

            val fragment = DescriptionFragment()
            fragment.arguments = args
            return fragment
        }
    }
}