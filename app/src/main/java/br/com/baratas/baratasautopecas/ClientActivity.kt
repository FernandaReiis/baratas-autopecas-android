package br.com.baratas.baratasautopecas

import android.content.Context
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_client.*
import kotlinx.android.synthetic.main.nav_view.*
import kotlinx.android.synthetic.main.toolbar.*


class ClientActivity : DebugActivity() {
    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)

        this.drawerLayout = layoutLateralMenu
        this.navView = lateral_menu
        this.currentContext = this
        this.progressBar = progressBarClient

        var args = intent.extras
        val client = args?.getString("client")

        setSupportActionBar(toolbar_view)
        supportActionBar?.title = client
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        configureLateralMenu()
    }
}