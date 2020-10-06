package br.com.baratas.baratasautopecas

import android.content.Context

object PartService {

    fun getParts(context: Context): List<Part> {
        val parts = mutableListOf<Part>()

        for (i in 1..10) {
            val c = Part()
            c.name = "Peça $i"
            c.description = "Descrição $i"
            c.price = "Preço $i"
            c.producer = "Fabricante $i"
            c.quantity = "Quantidade $i"
            c.photo = "https://chiptronic.com.br/blog/wp-content/uploads/2016/09/4-passos-para-encontrar-o-melhor-fornecedor-de-autope%C3%A7as-1.jpg"
            parts.add(c)
        }
        return parts
    }
}