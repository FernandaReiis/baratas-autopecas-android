package br.com.baratas.baratasautopecas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
        this.currentContext = this
        this.progressBar = progressBarHomeScreen

        var args = intent.extras
        val name = args?.getString("username")

        Toast.makeText(this, "Bem-vindo $name", Toast.LENGTH_LONG).show()

        setSupportActionBar(toolbar_view)
        supportActionBar?.title = "Clientes"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configureLateralMenu()

        first_btn.setOnClickListener { onClickButtons(first_btn.text.toString()) }
        second_btn.setOnClickListener { onClickButtons(second_btn.text.toString()) }
        third_btn.setOnClickListener { onClickButtons(third_btn.text.toString()) }
    }

    private fun onClickButtons(nameButton: String){
        val intent = Intent(context, ClientActivity::class.java)
        intent.putExtra("client", nameButton)
        startActivity(intent)
    }
}