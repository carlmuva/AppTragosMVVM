package com.example.apptragosmvvm.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T,position:Int)
} // ESTA CLASE LA UTILIZAMOS COMO BASE PARA FACILITAR LA CREACION DEL VIEWHOLDER PARA PODER IMPLEMENTARLO EN NUESTRO ADAPTER