package br.com.baratas.baratasautopecas

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_stock.*
import kotlinx.android.synthetic.main.nav_view.*
import kotlinx.android.synthetic.main.toolbar.*


class StockActivity : DebugActivity()  {
    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stock)
        this.drawerLayout = layoutLateralMenu
        this.navView = lateral_menu

        setSupportActionBar(toolbar_view)
        supportActionBar?.title = "Estoque"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configureLateralMenu()
    }
}