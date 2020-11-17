package br.com.baratas.baratasautopecas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_customers.*
import kotlinx.android.synthetic.main.activity_customers.layoutLateralMenu
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.nav_view.*
import kotlinx.android.synthetic.main.toolbar.*

class HomeScreenActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        this.drawerLayout = layoutLateralMenu
        this.navView = lateral_menu
        this.currentContext = this
        part_quantity.text = "8"
        customer_quantity.text = "10"
        employee_quantity.text = "15"
        provider_quantity.text = "2"
        sale_quantity.text = "30"
        vehicle_types.text = "2"

        var args = intent.extras
        val name = args?.getString("username")

        Toast.makeText(this, "Bem-vindo $name", Toast.LENGTH_LONG).show()

        setSupportActionBar(toolbar_view)
        supportActionBar?.title = "Dashboard"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configureLateralMenu()
    }

}