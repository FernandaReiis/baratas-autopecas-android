package br.com.baratas.baratasautopecas

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object PartService {

    val host = "http://pabloalmeida.pythonanywhere.com"
    val TAG = "WS_BaratasAutoPecas"

    fun getParts(context: Context): List<Part> {
        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/pecas"
            val json = HttpHelper.get(url)

            Log.d(TAG, json)
            var parts = parserJson<List<Part>>(json)
            parts.forEach { saveOffline(it) }

            return parts
        } else {
            val dao = DatabaseManager.getPartDAO()
            val parts = dao.findAll()
            return parts
        }
    }

    fun savePart(part: Part): Response {
        if (AndroidUtils.isInternetDisponivel()) {
            val json = HttpHelper.post("$host/pecas", part.toJson())
            return parserJson(json)
        }
        else {
            saveOffline(part)
            return Response("OK", "Disciplina salva no dispositivo")
        }
    }

    fun saveOffline(part: Part) : Boolean {
        val dao = DatabaseManager.getPartDAO()

        if (! existPart(part)) {
            dao.insert(part)
        }

        return true

    }

    fun existPart(part: Part): Boolean {
        val dao = DatabaseManager.getPartDAO()
        return dao.getById(part.id) != null
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}