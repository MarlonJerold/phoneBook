package com.example.contatos.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ContatosDatabase(
    context: Context
): SQLiteOpenHelper(context, "contatos.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = """
            CREATE TABLE TB_CONTATOS(
                ID INTEGER PRIMARY kEY AUTOIMCREMENT,
                NOME TEXT,
                TELEFONE TEXT,
                EMAIL TEXT
            );
        """.trimIndent()

        db?.execSQL(sql)

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS TB_CONTATOS")
        onCreate(db)
    }

    companion object
}