package com.example.contatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.contatos.database.ContatosDatabase


class CadastroActivity2 : AppCompatActivity() {

    private lateinit var editTextNome: EditText
    private lateinit var editTextTelefone: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var buttonSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro2)

        editTextNome = findViewById(R.id.editTextNome)
        editTextTelefone = findViewById(R.id.editTextTelefone)
        editTextEmail = findViewById(R.id.editTextEmail)
        buttonSalvar = findViewById(R.id.buttonSalvar)

        buttonSalvar.setOnClickListener {
            salvarContato()
        }

    }

    private fun salvarContato() {
        val contato = Contato(
            nome = editTextNome.text.toString(),
            telephony = editTextTelefone.text.toString(),
            email = editTextEmail.text.toString()
        )

        val idContato = ContatosDatabase.inserirContatos(contato)

        if (idContato == -1L) {
            Toast.makeText(this, "Erro ao inserir",
                Toast.LENGTH_SHORT)
                .show()
        } else {
            Toast.makeText(this, "Contato inserido com sucesso id: $idContato", Toast )
        }

    }

}