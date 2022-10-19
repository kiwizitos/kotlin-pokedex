package com.kiwizitos.pokedex

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kiwizitos.pokedex.databinding.FragmentPokedexCardBinding
import com.kiwizitos.pokedex.databinding.FragmentPokedexListBinding
import org.w3c.dom.Entity

class PokedexCardFragment: Fragment() {
    private var _binding: FragmentPokedexCardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokedexCardBinding.inflate(inflater, container, false)
        return binding.root
    }
}