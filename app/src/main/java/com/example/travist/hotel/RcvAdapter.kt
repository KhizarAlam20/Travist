package com.example.travist.hotel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.travist.R

class rcvAdapter(val context: Context, val hotelDetails: ArrayList<hotelDetailClass>,
    val listner: OnItemClickListner
) : RecyclerView.Adapter<rcvAdapter.exampleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): exampleViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.rcv_item,parent,false)
        return exampleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hotelDetails.size
    }

    override fun onBindViewHolder(holder: exampleViewHolder, position: Int) {
        val currentItem = hotelDetails[position]
        holder.hotel_name.text = currentItem.hotelName
        holder.hotel_description.text = currentItem.hotelDescription
        holder.hotel_price.text = currentItem.price
        holder.hotel_image.setImageResource(currentItem.hotelImage)
    }

   inner class exampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val hotel_name: TextView = itemView.findViewById(R.id.hotel_name)
        val hotel_description: TextView = itemView.findViewById(R.id.hotel_description)
        val hotel_price: TextView = itemView.findViewById(R.id.hotel_price)
        val hotel_image: ImageView = itemView.findViewById(R.id.rcv_image)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position:Int = adapterPosition

            if(position != RecyclerView.NO_POSITION){
                listner.onItemClick(position)
            }

        }

    }

    interface OnItemClickListner{
        fun onItemClick(position : Int)
    }
}