package com.kiwizitos.pokedex.presentor

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.kiwizitos.pokedex.R
import com.kiwizitos.pokedex.databinding.FragmentPokedexListBinding
import com.kiwizitos.pokedex.presentor.adapter.PokemonAdapter

class PokedexListFragment : Fragment() {
    private var _binding: FragmentPokedexListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PokemonAdapter

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
        recyclerView = binding.recyclerView
        viewModel.getResponse()
        viewModel.pokemonList.observe(viewLifecycleOwner) { it ->
            adapter = PokemonAdapter(it) {
//                Toast.makeText(requireContext(), it.name,  Toast.LENGTH_SHORT).show()
                val directions =
                    PokedexListFragmentDirections.actionPokedexListFragmentToPokedexCardFragment(
                        pokemonNumber = it.num,
                        pokemonImage = it.img,
                        pokemonName = it.name,
                        pokemonType = it.type.toTypedArray()
                    )
                Navigation.findNavController(view).navigate(directions)
            }
            recyclerView.adapter = adapter
        }

//        (activity as AppCompatActivity).supportActionBar?.title = "Pokedex"
//        (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(context?.let {
//            ContextCompat.getColor(
//                it,
//                R.color.colorAccent
//            )
//        }
//            ?.let {
//                ColorDrawable(
//                    it
//                )
//            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}