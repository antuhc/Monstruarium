package com.example.monstruarium

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.monstruarium.databinding.ViewMonsterItemBinding
import com.example.monstruarium.model.Monster

class MonsterAdapter(var monsters: List<Monster>, private val monsterClickedListener: (Monster) -> Unit) :
    RecyclerView.Adapter<MonsterAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ViewMonsterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //Aqui se cargan los elementos
        fun bind(monster: Monster) {
            binding.name.text = monster.name
            Glide.with(binding.root.context).load(monster.cover).into(binding.monsterImage)
        }
    }

    // Crea una nueva vista cuando el RecyclerView lo pida
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewMonsterItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    //Actualizar la vista o reciclarla
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val monster = monsters[position]
        holder.bind(monster)
        holder.itemView.setOnClickListener { monsterClickedListener(monster) }
    }

    //Numero de elementos en el adapter
    override fun getItemCount() = monsters.size
}