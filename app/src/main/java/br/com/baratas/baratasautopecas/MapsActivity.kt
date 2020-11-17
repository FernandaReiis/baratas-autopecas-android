package br.com.baratas.baratasautopecas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MapsActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
    }

    override fun onResume() {
        super.onResume()
        val mapFragment = MapFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.layoutMaps, mapFragment)
            .commit()
    }
}