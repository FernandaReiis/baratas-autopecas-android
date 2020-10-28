package br.com.baratas.baratasautopecas

import android.content.SharedPreferences

object Prefs {

    private fun prefs(): SharedPreferences {
        val context = BaratasApplication.getInstance().applicationContext
        return context.getSharedPreferences("BaratasAutoPecas", 0)
    }

    fun setString(flag: String, valor: String) = prefs().edit().putString(flag, valor).apply()

    fun getString(flag: String) = prefs().getString(flag, "")

    fun setBoolean(flag: String, valor: Boolean) = prefs().edit().putBoolean(flag, valor).apply()

    fun getBoolean(flag: String) = prefs().getBoolean(flag, false)
}