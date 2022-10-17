package com.kiwizitos.pokedex

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.kiwizitos.pokedex.databinding.FragmentPokedexListBinding
import com.kiwizitos.pokedex.network.PokemonApi
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class PokedexListFragment : Fragment() {
    private var _binding: FragmentPokedexListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    lateinit var adapter: PokemonAdapter

    private val viewModel: PokemonViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPokedexListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recylerView
        viewModel.getResponse()
        viewModel.pokemonList.observe(viewLifecycleOwner) {
            adapter = PokemonAdapter(it) {
                Toast.makeText(requireContext(), it.name, Toast.LENGTH_SHORT).show()
                Navigation.findNavController(view).navigate(R.id.action_pokedexListFragment_to_pokedexCardFragment)
            }
            recyclerView.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}