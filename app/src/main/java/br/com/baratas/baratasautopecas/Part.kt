package br.com.baratas.baratasautopecas

class Part{
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
}