package com.kiwizitos.pokedex

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kiwizitos.pokedex.databinding.CardViewBinding

class PokemonAdapter(val pokemons: List<PokemonEntity>, private val onItemClicked: (PokemonEntity) -> Unit): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    class ViewHolder(private var binding: CardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PokemonEntity) {
            binding.pokemonImage.load(item.image)
            binding.pokemonName.text = item.name
            binding.pokemonType.text = item.type
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CardViewBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = pokemons[position]
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }
}
