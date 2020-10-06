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
    val parts: List<Part>,
    val onClick: (Part) -> Unit
): RecyclerView.Adapter<PartAdapter.PartsViewHolder>() {
    class PartsViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cardName: TextView
        val cardImg: ImageView
        val cardProgress: ProgressBar
        val cardView: CardView

        init {
            cardName = view.findViewById(R.id.card_name)
            cardImg = view.findViewById(R.id.card_img)
            cardProgress = view.findViewById(R.id.card_progressbar)
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
        val context = holder.itemView.context

        val part = this.parts[position]

        holder.cardName.text = part.name
        holder.cardProgress.visibility = View.VISIBLE

        Picasso.with(context).load(part.photo).fit().into(
            holder.cardImg,
            object: com.squareup.picasso.Callback {
                override fun onSuccess() {
                    holder.cardProgress.visibility = View.GONE
                }

                override fun onError() {
                    holder.cardProgress.visibility = View.GONE
                }
            })
        holder.itemView.setOnClickListener {onClick(part)}
    }
}