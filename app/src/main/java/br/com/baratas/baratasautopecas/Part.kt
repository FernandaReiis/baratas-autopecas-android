package br.com.baratas.baratasautopecas

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName = "part")
class Part: Serializable{

    @PrimaryKey
    var id: Long = 0
    var name: String = ""
    var description: String = ""
    var price: String = ""
    var quantity: String = ""
    var producer: String = ""
    var photo: String = ""

    override fun toString(): String {
        return "Part(nome=$name)"
    }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}