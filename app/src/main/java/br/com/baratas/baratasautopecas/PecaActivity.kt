package br.com.baratas.baratasautopecas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.toolbar.*

class PecaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peca)
        var args = intent.extras
        val title = args?.getString("title")

        setSupportActionBar(toolbar_view)
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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
}