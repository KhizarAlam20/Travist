package com.example.travist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class rcvAdapter (val context: Context, val hotelDetails : ArrayList<hotelDetailClass>) : RecyclerView.Adapter<rcvAdapter.exampleViewHolder>() {

    class exampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hotel_name :TextView = itemView.findViewById(R.id.hotel_name)
        val hotel_description :TextView = itemView.findViewById(R.id.hotel_description)
        val hotel_price :TextView = itemView.findViewById(R.id.hotel_price)
        val hotel_image : ImageView = itemView.findViewById(R.id.rcv_image)
    }

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
}