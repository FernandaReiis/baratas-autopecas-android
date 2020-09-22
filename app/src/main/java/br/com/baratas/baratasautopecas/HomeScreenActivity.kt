package br.com.baratas.baratasautopecas

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.toolbar.*

class HomeScreenActivity : AppCompatActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        var args = intent.extras
        val name = args?.getString("username")

        Toast.makeText(this, "Bem-vindo $name", Toast.LENGTH_LONG).show()

        setSupportActionBar(toolbar_view)
        supportActionBar?.title = "Estoque"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        first_btn.setOnClickListener { onClickButtons(first_btn.text.toString()) }
        second_btn.setOnClickListener { onClickButtons(second_btn.text.toString()) }
        third_btn.setOnClickListener { onClickButtons(third_btn.text.toString()) }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item?.itemId) {
            R.id.action_search -> Toast.makeText(this, "Botão buscar", Toast.LENGTH_LONG).show()
            R.id.action_add -> Toast.makeText(this, "Botão adicionar", Toast.LENGTH_LONG).show()
            R.id.action_config -> Toast.makeText(this, "Botão configurações", Toast.LENGTH_LONG).show()
            R.id.action_refresh -> Toast.makeText(this, "Botão atualizar", Toast.LENGTH_LONG).show()
            android.R.id.home -> finish()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun onClickButtons(nameButton: String){
        val intent = Intent(context, PecaActivity::class.java)
        intent.putExtra("title", nameButton)
        startActivity(intent)
    }
}