package br.com.baratas.baratasautopecas

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.toolbar.*

open class DebugActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private val context: Context get() = this
    private val TAG = "BaratasAutoPecas"
    private val className: String
        get() {
            val s = javaClass.name
            return s.substring(s.lastIndexOf("."))
        }

    var drawerLayout: DrawerLayout? = null
    var navView: NavigationView? = null
    var currentContext: Context? = null
    var progressBar: View? = null

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
            R.id.nav_customer -> {
                var intent = Intent(this, CustomersActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_employee-> { Toast.makeText(this, "Clicou em Funcionário", Toast.LENGTH_LONG).show() }
            R.id.nav_payment_method -> { Toast.makeText(this, "Clicou em Método de Pagamento", Toast.LENGTH_LONG).show() }
            R.id.nav_product -> { Toast.makeText(this, "Clicou em Produto", Toast.LENGTH_LONG).show() }
            R.id.nav_provider -> { Toast.makeText(this, "Clicou em Fornecedor", Toast.LENGTH_LONG).show() }
            R.id.nav_sale -> { Toast.makeText(this, "Clicou em Venda", Toast.LENGTH_LONG).show() }
            R.id.nav_stock -> {
                var intent = Intent(this, StockActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_vehicle -> { }
            R.id.nav_logout -> { onClickLogout() }
            R.id.nav_localization -> {
                var intent = Intent(this, MapsActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_dashboard -> {
                var intent = Intent(this, HomeScreenActivity::class.java)
                startActivity(intent)
            }
        }

        drawerLayout?.closeDrawer(GravityCompat.START)

        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        (menu?.findItem(R.id.action_search)?.actionView as SearchView).setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                Toast.makeText(currentContext, newText, Toast.LENGTH_LONG).show()
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(currentContext, query, Toast.LENGTH_LONG).show()
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
            R.id.action_refresh -> {
                Toast.makeText(this, "Botão atualizar", Toast.LENGTH_LONG).show()
                onClickRefresh()
            }
            R.id.action_add_part -> {
                val it = Intent(this, NewPartActivity::class.java)
                startActivity(it)
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
        progressBar?.visibility = View.VISIBLE
        Handler().postDelayed( {
            progressBar?.visibility = View.GONE
        }, 10000)
    }

    private fun onClickLogout() {
        val intent = Intent(context, MainActivity::class.java)
        startActivity(intent)
    }


}
