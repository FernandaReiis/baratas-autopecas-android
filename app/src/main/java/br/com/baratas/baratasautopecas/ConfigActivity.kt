package br.com.baratas.baratasautopecas

import android.content.Context
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_config.*
import kotlinx.android.synthetic.main.nav_view.*
import kotlinx.android.synthetic.main.toolbar.*


class ConfigActivity : DebugActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)

        this.drawerLayout = layoutLateralMenu
        this.navView = lateral_menu
        this.currentContext = this
        this.progressBar = progressBarConfig

        setSupportActionBar(toolbar_view)
        supportActionBar?.title = "Configurações"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        configureLateralMenu()
    }

}