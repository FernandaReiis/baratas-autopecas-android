package br.com.baratas.baratasautopecas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PartAdapter(
    val parts: List<Part>
): RecyclerView.Adapter<PartAdapter.PartsViewHolder>() {
    class PartsViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cardName: TextView
        val cardQuantity: TextView
        val cardView: CardView

        init {
            cardName = view.findViewById(R.id.card_name)
            cardQuantity = view.findViewById(R.id.card_quantity)
            cardView = view.findViewById(R.id.part_card)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.part_adapter, parent, false)

        val holder = PartsViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int = this.parts.size

    override fun onBindViewHolder(holder: PartsViewHolder, position: Int) {
        val part = this.parts[position]

        holder.cardName.text = part.name
        holder.cardQuantity.text = part.quantity
    }
}