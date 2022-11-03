package com.kiwizitos.pokedex.presentor.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kiwizitos.pokedex.PokemonColorUtil
import com.kiwizitos.pokedex.databinding.CardViewBinding
import com.kiwizitos.pokedex.domain.PokemonEntity

class PokemonAdapter(private val pokemons: List<PokemonEntity>, private val onItemClicked: (PokemonEntity) -> Unit): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    class ViewHolder(private var binding: CardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PokemonEntity) {
            binding.pokemonImage.load(item.img)
            binding.pokemonName.text = item.name
            binding.pokemonNumber.text = item.num

            item.type.getOrNull(0).let {
                binding.pokemonType.text = it.toString()
                binding.pokemonType.isVisible = it != null
            }
            item.type.getOrNull(1).let {
                binding.pokemonType2.text = it.toString()
                binding.pokemonType2.isVisible = it != null
            }
            item.type.getOrNull(2).let {
                binding.pokemonType3.text = it.toString()
                binding.pokemonType3.isVisible = it != null
            }

            val color = PokemonColorUtil(itemView.context).getPokemonColor(item.type)
            binding.cardView.setCardBackgroundColor(color)
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
