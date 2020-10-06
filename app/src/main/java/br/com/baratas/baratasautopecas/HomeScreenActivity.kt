package br.com.baratas.baratasautopecas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.nav_view.*
import kotlinx.android.synthetic.main.toolbar.*


class HomeScreenActivity : DebugActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        this.drawerLayout = layoutLateralMenu
        this.navView = lateral_menu

        var args = intent.extras
        val name = args?.getString("username")

        Toast.makeText(this, "Bem-vindo $name", Toast.LENGTH_LONG).show()

        setSupportActionBar(toolbar_view)
        supportActionBar?.title = "Estoque"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configureLateralMenu()

        first_btn.setOnClickListener { onClickButtons(first_btn.text.toString()) }
        second_btn.setOnClickListener { onClickButtons(second_btn.text.toString()) }
        third_btn.setOnClickListener { onClickButtons(third_btn.text.toString()) }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        (menu?.findItem(R.id.action_search)?.actionView as SearchView).setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                Toast.makeText(this@HomeScreenActivity, newText, Toast.LENGTH_LONG).show()
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(this@HomeScreenActivity, query, Toast.LENGTH_LONG).show()
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

    private fun onClickButtons(nameButton: String){
        val intent = Intent(context, PecaActivity::class.java)
        intent.putExtra("title", nameButton)
        startActivity(intent)
    }

    private fun onClickConfig(){
        val intent = Intent(context, ConfigActivity::class.java)
        startActivity(intent)
    }

    private fun onClickRefresh(){
        progressBarHomeScreen.visibility = View.VISIBLE
        Handler().postDelayed( {
           progressBarHomeScreen.visibility = View.GONE
        }, 10000)
    }

    private fun onClickLogout() {
        val intent = Intent(context, MainActivity::class.java)
        startActivity(intent)
    }
}