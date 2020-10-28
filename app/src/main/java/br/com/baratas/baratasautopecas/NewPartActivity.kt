package br.com.baratas.baratasautopecas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new_part.*

class NewPartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_part)

        savePart.setOnClickListener {
            var p = Part()
            p.name = partName.text.toString()
            p.description = partDescription.text.toString()
            p.quantity = partQuantity.text.toString()
            p.producer = partProducer.text.toString()
            p.price = partPrice.text.toString()
            p.photo = partUrlFoto.text.toString()

            Thread {
                PartService.savePart(p)
                runOnUiThread() {
                    finish()
                }
            }.start()

        }
    }
}