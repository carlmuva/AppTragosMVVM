package com.example.apptragosmvvm.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apptragosmvvm.R
import com.example.apptragosmvvm.base.BaseViewHolder
import com.example.apptragosmvvm.data.model.Drink
import com.example.apptragosmvvm.databinding.TragosRowBinding


class MainAdapter(private val context: Context, private val tragosList: List<Drink>, private val itemClickListener:OnTragoClickListener ) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnTragoClickListener{
        fun onTragoClick(drink: Drink)
    }


    inner class MainViewHolder(itemView: View) : BaseViewHolder<Drink>(itemView) {
        val binding = TragosRowBinding.bind(itemView)

        override fun bind(item: Drink, position: Int) {
            Glide.with(binding.imgTrago.context)
                .load(item.imagen)
                .centerCrop()
                .into(binding.imgTrago)
            binding.txtTitulo.text = item.nombre
            binding.txtDescripcion.text = item.descripcion
            binding.content.setOnClickListener{itemClickListener.onTragoClick(item)}
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<*> {  // Aqui inflamos la vista
        return MainViewHolder(
            LayoutInflater.from(context).inflate(R.layout.tragos_row, parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder<*>,
        position: Int
    ) { // aqui bindeamos los items
        when (holder) {
            is MainViewHolder -> holder.bind(tragosList[position], position)
        }
    }

    override fun getItemCount(): Int {
        return tragosList.size
    }


}