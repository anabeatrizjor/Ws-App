package com.example.app123_practice

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    companion object {
        val listaDeUsers = mutableListOf<CadastroActivity.Users>()
    }

    private lateinit var userInput : EditText
    private lateinit var senhaInput : EditText


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userInput = findViewById(R.id.userInputlLogin)
        senhaInput = findViewById(R.id.senhaInputLogin)
        val loginBtn = findViewById<Button>(R.id.buttonLogin)
        val cadastroBtn = findViewById<Button>(R.id.buttonCadastroLogin)

        cadastroBtn.setOnClickListener {
            startActivity(Intent(this@LoginActivity, CadastroActivity::class.java))
        }

        loginBtn.setOnClickListener {
            realizarLogin()
        }

    }

    private fun realizarLogin() {

        val user = userInput.text.toString()
        val senha = senhaInput.text.toString()

        var errorSenha = false
        var errorUser = false

        if (errorSenha) {
            senhaInput.background = ContextCompat.getDrawable(this, R.drawable.border_error)
        }

        if (errorUser) {
            userInput.background = ContextCompat.getDrawable(this, R.drawable.border_error)
        }

        if (user.isEmpty()) {
            userInput.error = "Todos os campos devem ser preenchidos"
            errorUser = true
        }

        if (senha.isEmpty()) {
            senhaInput.error = "Todos os campos devem ser preenchidos"
            errorSenha = true
        }

        val findUser = CadastroActivity.listaDeUsers.find { user == it.user && senha == it.senha }

        if (findUser != null) {
            Toast.makeText(this, "Login realizado com sucesso", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        }else{

        }
    }

    private fun exibirDialogo(mensagem: String) {
        AlertDialog.Builder(this)
            .setTitle("ATENÇÃO")
            .setMessage(mensagem)
            .setPositiveButton("OK") { dialog,_ ->
                dialog.dismiss()
            }
            .show()
    }
}