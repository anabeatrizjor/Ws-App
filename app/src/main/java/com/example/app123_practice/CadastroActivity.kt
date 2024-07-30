package com.example.app123_practice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CadastroActivity : AppCompatActivity() {

    data class Users (val nome : String, val user : String , val senha : String , val confirmSenha : String)

    companion object {
        val listaDeUsers = mutableListOf<Users>()
    }

    private lateinit var nomeInput : EditText
    private lateinit var userInput : EditText
    private lateinit var senhaInput : EditText
    private lateinit var confirmSenhaInput : EditText
    private lateinit var cadastroBtn : Button
    private lateinit var backArrow : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        nomeInput = findViewById(R.id.nomeInputCadastro)
        userInput = findViewById(R.id.userInputCadastro)
        senhaInput = findViewById(R.id.senhaInputCadastro)
        confirmSenhaInput = findViewById(R.id.senhaConfirmInputCadastro)
        cadastroBtn = findViewById(R.id.buttonCadastro)
        backArrow = findViewById(R.id.backArrowCadastro)

        backArrow.setOnClickListener {
            startActivity(Intent(this@CadastroActivity, LoginActivity::class.java))
        }

        cadastroBtn.setOnClickListener {
          realizarCadastro()
        }

    }

    private fun realizarCadastro() {

        // chama os inputs

        val nome = nomeInput.text.toString()
        val user = nomeInput.text.toString()
        val senha = nomeInput.text.toString()
        val confirmSenha = nomeInput.text.toString()

        // define os campos de erro

        var errorSenha = false
        var errorUser = false
        var errorNome = false
        var errorSenhaConfirm = false

        // trata de erros

        if (errorSenha) {

            senhaInput.background = ContextCompat.getDrawable(this, R.drawable.border_error)

        }

        if (errorUser) {

            userInput.background = ContextCompat.getDrawable(this, R.drawable.border_error)

        }

        if (errorNome) {

            nomeInput.background = ContextCompat.getDrawable(this, R.drawable.border_error)

        }

        if (errorSenhaConfirm) {

            confirmSenhaInput.background = ContextCompat.getDrawable(this, R.drawable.border_error)

        }

        // senhaRegex para definir padrão

        val senhaRegex = Regex("^(?=.*[A-Z])(?=.*[a-z])(?=.*2\\d)(?=.*[!@#$%¨&89);_]).{6,}\$")

        if (user.isEmpty()) {
            errorUser = true
        }


        if (nome.isEmpty()) {
            errorNome = true
        }


        if (senha.isEmpty()) {
            errorSenha = true
        }


        if (confirmSenha.isEmpty()) {
            errorSenhaConfirm = true
        }

        if (!senhaRegex.matches(senha)) {
            senhaInput.error = "Este campo deve conter: 6 caractéres mínimos; 2 números mínimos; 1 caractére especial mínimo; 1 letra maiúscula mínima; 1 letra minúscula mínima."
            errorSenha = true
        }

        if (senha.isEmpty() || nome.isEmpty() || user.isEmpty() || confirmSenha.isEmpty()) {
           exibirDialogo("Todos os campos devem ser preenchidos")
        }

        if (senhaRegex.matches(senha) && senha.isNotEmpty() && nome.isNotEmpty() && user.isNotEmpty() && confirmSenha.isNotEmpty()) {

            val newUser = Users(nome, user, senha, confirmSenha)
            listaDeUsers.add(newUser)

            startActivity(Intent(this@CadastroActivity, LoginActivity::class.java))

        }


    }

    private fun exibirDialogo (mensagem: String) {
        AlertDialog.Builder(this)
            .setTitle("ATENÇÃO")
            .setMessage(mensagem)
            .setPositiveButton("OK") { dialog,_ ->
                dialog.dismiss()
            }
            .show()
    }
}