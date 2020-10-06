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
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_part.*
import kotlinx.android.synthetic.main.toolbar.*
import java.io.Serializable

class PartActivity : AppCompatActivity(), Serializable {
    private val context: Context get() = this
    private val gson: Gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part)
        val part = gson.fromJson<Part>(intent.getStringExtra("part"), Part::class.java)

        setSupportActionBar(toolbar_view)
        supportActionBar?.title = part.name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        Toast.makeText(this, part.toString() , Toast.LENGTH_LONG).show()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        (menu?.findItem(R.id.action_search)?.actionView as SearchView).setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                Toast.makeText(this@PartActivity, newText, Toast.LENGTH_LONG).show()
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(this@PartActivity, query, Toast.LENGTH_LONG).show()
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
        progressBarPart.visibility = View.VISIBLE
        Handler().postDelayed( {
            progressBarPart.visibility = View.GONE
        }, 10000)
    }

    private fun onClickLogout() {
        val intent = Intent(context, MainActivity::class.java)
        startActivity(intent)
    }
}