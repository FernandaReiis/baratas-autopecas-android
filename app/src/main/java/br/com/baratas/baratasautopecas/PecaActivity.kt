package br.com.baratas.baratasautopecas

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import kotlinx.android.synthetic.main.activity_config.*
import kotlinx.android.synthetic.main.activity_peca.*
import kotlinx.android.synthetic.main.toolbar.*

class PecaActivity : AppCompatActivity() {
    private val context: Context get() = this

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
        (menu?.findItem(R.id.action_search)?.actionView as SearchView).setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                Toast.makeText(this@PecaActivity, newText, Toast.LENGTH_LONG).show()
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(this@PecaActivity, query, Toast.LENGTH_LONG).show()
                return false
            }

        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item?.itemId) {
            R.id.action_search -> Toast.makeText(this, "Botão buscar", Toast.LENGTH_LONG).show()
            R.id.action_config -> {
                Toast.makeText(this, "Botão configurações", Toast.LENGTH_LONG).show()
                onClickConfig()
            }
            R.id.action_logout -> {
                Toast.makeText(this, "Botão Sair", Toast.LENGTH_LONG).show()
                onClickLogout()
            }
            R.id.action_refresh -> {
                Toast.makeText(this, "Botão atualizar", Toast.LENGTH_LONG).show()
                onClickRefresh()
            }
            android.R.id.home -> finish()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun onClickConfig(){
        val intent = Intent(context, ConfigActivity::class.java)
        startActivity(intent)
    }

    private fun onClickRefresh(){
        progressBarPeca.visibility = View.VISIBLE
        Handler().postDelayed( {
            progressBarPeca.visibility = View.GONE
        }, 10000)
    }

    private fun onClickLogout() {
        val intent = Intent(context, MainActivity::class.java)
        startActivity(intent)
    }
}