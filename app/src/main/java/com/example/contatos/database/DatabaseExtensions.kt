package com.example.contatos.database

import android.annotation.SuppressLint
import android.content.ContentValues
import com.example.contatos.Contato

fun ContatosDatabase.inserirContatos(item: Contato): Long {

    val idContato = writableDatabase.insert("TB_CONTATOS", null, ContentValues().apply {
        put("NOME", item.nome)
        put("TELEFONE", item.telephony)
        put("EMAIL", item.email)
    })
    return idContato
}


@SuppressLint("Range")
fun ContatosDatabase.selecionarContatos(): List<Contato> {
    val sql = "SELECT * FROM TB_CONTATOS"
    val cursor = readableDatabase.rawQuery(sql, null)
    val contatoList = mutableListOf<Contato>()

    if (cursor.count > 0) {
        while (cursor.moveToNext()) {

            val contato = Contato(
                id = cursor.getInt(cursor.getColumnIndex("ID")),
                nome = cursor.getString(cursor.getColumnIndex("NOME")),
                telephony = cursor.getString(cursor.getColumnIndex("TELEFONE")),
                email = cursor.getString(cursor.getColumnIndex("EMAIL"))
            )

            contatoList.add(contato)
        }

        cursor.close()
    }
    return contatoList
}