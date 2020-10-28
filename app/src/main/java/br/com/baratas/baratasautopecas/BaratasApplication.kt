package br.com.baratas.baratasautopecas

import android.app.Application
import java.lang.IllegalStateException

class BaratasApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: BaratasApplication? = null
        fun getInstance(): BaratasApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configurar application no Android Manifest")
            }
            return appInstance!!
        }
    }

}