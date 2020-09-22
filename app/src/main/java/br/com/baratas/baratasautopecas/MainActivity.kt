package br.com.baratas.baratasautopecas

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*


class MainActivity : AppCompatActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        welcomeLogin.text = "Bem-vindo, Faça seu Login!"
        imageField.setImageResource(R.drawable.autopecas)
        btnLogin.setOnClickListener {onClickLogin() }
    }

    private fun onClickLogin(){
        progressBarLogin.visibility = View.VISIBLE

        Handler().postDelayed( {
            val username = userField.text.toString()
            val password = passwordField.text.toString()

            val intent = Intent(context, HomeScreenActivity::class.java)

            intent.putExtra("username", username)

            if (username == "aluno" && password == "impacta") startActivityForResult(intent, 0)
            else Toast.makeText(this, "Usuário ou senha incorretos.", Toast.LENGTH_LONG).show()
            progressBarLogin.visibility = View.GONE
        }, 1000)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        userField.setText("")
        passwordField.setText("")
    }
}