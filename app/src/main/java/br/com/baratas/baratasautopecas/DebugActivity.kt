package br.com.baratas.baratasautopecas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.toolbar.*

open class DebugActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val TAG = "BaratasAutoPecas"
    private val className: String
        get() {
            val s = javaClass.name
            return s.substring(s.lastIndexOf("."))
        }

    var drawerLayout: DrawerLayout? = null
    var navView: NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, className + ".onCreate() chamado")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, className + ".onStart() chamado")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, className + ".onRestart() chamado")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, className + ".onResume() chamado")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, className + ".onPause() chamado")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, className + ".onStop() chamado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, className + ".onDestroy() chamado")
    }

    protected fun configureLateralMenu() {
        var toogle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar_view,
            R.string.navigation_drawer_open,
            R.string.navigation_drawe_close
        )

        drawerLayout?.addDrawerListener(toogle)
        toogle.syncState()

        navView?.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_customer -> { Toast.makeText(this, "Clicou em Cliente", Toast.LENGTH_LONG).show() }
            R.id.nav_employee-> { }
            R.id.nav_payment_method -> { }
            R.id.nav_product -> { }
            R.id.nav_provider -> { }
            R.id.nav_sale -> { }
            R.id.nav_stock -> {
                var intent = Intent(this, StockActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_vehicle -> { }
        }

        drawerLayout?.closeDrawer(GravityCompat.START)

        return true
    }


}
