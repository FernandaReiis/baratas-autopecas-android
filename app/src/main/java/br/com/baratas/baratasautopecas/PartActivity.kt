package br.com.baratas.baratasautopecas

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.activity_part.*
import kotlinx.android.synthetic.main.activity_part.layoutLateralMenu
import kotlinx.android.synthetic.main.nav_view.*
import kotlinx.android.synthetic.main.toolbar.*

import java.io.Serializable

class PartActivity : DebugActivity(), Serializable {
    private val context: Context get() = this
    private val gson: Gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part)

        this.drawerLayout = layoutLateralMenu
        this.navView = lateral_menu
        this.currentContext = this
        this.progressBar = progressBarPart


        val part = gson.fromJson<Part>(intent.getStringExtra("part"), Part::class.java)

        setSupportActionBar(toolbar_view)
        supportActionBar?.title = part.name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        configureLateralMenu()

        Toast.makeText(this, part.toString() , Toast.LENGTH_LONG).show()

    }
}