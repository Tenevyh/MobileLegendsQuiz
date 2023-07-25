package com.project.android.legend.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.geomain.R
import com.bignerdranch.android.geomain.databinding.ListItemBinding
import com.project.android.legend.DataClass.Hero

class HeroAdapter(private val listener: Listener): ListAdapter<Hero, HeroAdapter.Holder>(Comparator()) {


    class Holder(view: View, private val listener: Listener) : RecyclerView.ViewHolder(view) {
        private val binding = ListItemBinding.bind(view)
        private var itemHero: Hero? = null

        init {
            binding.bHero.setOnClickListener{
                itemHero?.let { it1 -> listener.onClick(it1) }
            }
        }

        fun bind(item: Hero) = with(binding){
            itemHero = item
            bHero.text = item.name
        }
    }

    class Comparator : DiffUtil.ItemCallback<Hero>(){
        override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return Holder(view, listener)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    interface Listener {
        fun onClick(item: Hero)
    }
}
