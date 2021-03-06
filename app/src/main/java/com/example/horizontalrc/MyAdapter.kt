package com.example.horizontalrc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.horizontalrc.R.drawable.ic_launcher_background
import com.example.horizontalrc.models.BoardSize
import kotlin.math.min

class MyAdapter(
    private val context: Context,
    private val numPieces: BoardSize,
    private val randomIcons: List<Int>
):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    companion object{
        private  const val MARGIN = 10
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val cardWidth = parent.width/numPieces.getWidth() - (2 * MARGIN)
        val cardHeight = parent.height/numPieces.getHeight() - (2 * MARGIN)
        val cardSideLength = min(cardWidth,cardHeight)
        val layout = LayoutInflater.from(context).inflate(R.layout.memory_card,parent,false)
        val cardView = layout.findViewById<CardView>(R.id.cardView).layoutParams as ViewGroup.MarginLayoutParams
        cardView.width = cardSideLength
        cardView.height = cardSideLength
        cardView.setMargins(MARGIN, MARGIN, MARGIN, MARGIN)



        return MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        holder.bind(position)

    }

    override fun getItemCount(): Int {
        return numPieces.numCards
    }
    inner class MyViewHolder(view:View):RecyclerView.ViewHolder(view){
        private  val imageButton =view.findViewById<ImageButton>(R.id.imageButton)
        fun bind(position: Int) {

            imageButton.setImageResource(randomIcons[position])
            imageButton.setOnClickListener {


                Toast.makeText(context,"position $position",Toast.LENGTH_LONG).show()
            }

        }

    }
}


