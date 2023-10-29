package com.example.travist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.travist.hotel.hotelDetailClass
import com.example.travist.hotel.rcvAdapter

class RcvFlightAdapter (val context: Context, val flightDetails: ArrayList<FlightDetailClass>,
                        val listner: OnItemClickListner) : RecyclerView.Adapter<RcvFlightAdapter.exampleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): exampleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rcv_flight_item,parent,false)
        return exampleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return flightDetails.size
    }

    override fun onBindViewHolder(holder: exampleViewHolder, position: Int) {
        val currentItem = flightDetails[position]
        holder.flight_name.text = currentItem.flightName
        holder.flight_description.text = currentItem.flightDescription
        holder.flight_price.text = currentItem.price
        holder.flight_image.setImageResource(currentItem.flightImage)
    }

    inner class exampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val flight_name: TextView = itemView.findViewById(R.id.flight_name)
        val flight_description: TextView = itemView.findViewById(R.id.flight_description)
        val flight_price: TextView = itemView.findViewById(R.id.flight_price)
        val flight_image: ImageView = itemView.findViewById(R.id.rcv_image)

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