package com.example.contatos

import android.view.TextureView
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContatoViewHolder( view: View ): RecyclerView.ViewHolder(view) {

    private val textViewNome = itemView.findViewById<TextView>(R.id.textViewNome)
    private val textViewTelefone = itemView.findViewById<TextView>(R.id.textViewTelefone)

    fun bind(item: Contato) {
        textViewNome.text = item.nome
        textViewTelefone.text = item.telephony
    }

}