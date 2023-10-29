package com.example.travist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RcvResturantAdapter  (val context: Context, val resDetails: ArrayList<ResturantDetailClass>,
                            val listner: OnItemClickListner) : RecyclerView.Adapter<RcvResturantAdapter.exampleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): exampleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rcv_resturant_item,parent,false)
        return exampleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return resDetails.size
    }

    override fun onBindViewHolder(holder: exampleViewHolder, position: Int) {
        val currentItem = resDetails[position]
        holder.res_name.text = currentItem.resName
        holder.res_description.text = currentItem.resDescription
        holder.res_price.text = currentItem.price
        holder.res_image.setImageResource(currentItem.resImage)
    }

    inner class exampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val res_name: TextView = itemView.findViewById(R.id.res_name)
        val res_description: TextView = itemView.findViewById(R.id.res_description)
        val res_price: TextView = itemView.findViewById(R.id.res_price)
        val res_image: ImageView = itemView.findViewById(R.id.rcv_image)

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