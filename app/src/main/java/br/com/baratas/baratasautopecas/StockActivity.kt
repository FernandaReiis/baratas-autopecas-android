package br.com.baratas.baratasautopecas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_customers.*
import kotlinx.android.synthetic.main.activity_stock.*
import kotlinx.android.synthetic.main.activity_stock.layoutLateralMenu
import kotlinx.android.synthetic.main.nav_view.*
import kotlinx.android.synthetic.main.toolbar.*
import java.io.Serializable


class StockActivity : DebugActivity()  {
    private val context: Context get() = this
    private val gson: Gson = Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stock)
        this.drawerLayout = layoutLateralMenu
        this.navView = lateral_menu
        this.progressBar = progressBarStock

        setSupportActionBar(toolbar_view)
        supportActionBar?.title = "Estoque"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        configureLateralMenu()

        partsRecycler?.layoutManager = LinearLayoutManager(this)
        partsRecycler?.itemAnimator = DefaultItemAnimator()
        partsRecycler?.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        partsTask()
    }

    private var parts = listOf<Part>()
    fun partsTask() {
        Thread{
            parts = PartService.getParts(context)
            runOnUiThread {
                partsRecycler?.adapter = PartAdapter(parts)
            }
        }.start()

    }

}