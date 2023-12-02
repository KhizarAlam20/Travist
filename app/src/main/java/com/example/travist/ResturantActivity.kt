package com.example.travist

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ResturantActivity : AppCompatActivity(), RcvResturantAdapter.OnItemClickListner {
    lateinit var rcvRes: RecyclerView
    lateinit var res_name: Array<String>
    lateinit var newArrayList: ArrayList<ResturantDetailClass>
    lateinit var res_image: Array<Int>
    lateinit var res_price: Array<String>
    lateinit var res_description: Array<String>


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resturant)

        res_image = arrayOf(
            R.drawable.h1,
            R.drawable.h2,
            R.drawable.h3,
            R.drawable.h4,
            R.drawable.h5
        )

        res_name = arrayOf(
            "Restaurant A",
            "Restaurant B",
            "Restaurant C",
            "Restaurant D",
            "Restaurant E",
        )

        res_price = arrayOf(
            "$150",
            "$900",
            "$260",
            "$350",
            "$880",
        )

        res_description = arrayOf(
            "Asian Flights",
            "North American",
            "Europe",
            "Southern Flight",
            "African Flights",
        )

        rcvRes = findViewById(R.id.rcvRes)

        rcvRes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        newArrayList = arrayListOf<ResturantDetailClass>()

        getUserData()

//        rcv.adapter = rcvAdapter(this,listCategories)

    }

    private fun getUserData() {
        for (i in res_image.indices) {
            val news = ResturantDetailClass(
                res_name[i],
                res_description[i],
                res_price[i],
                res_image[i]
            )
            newArrayList.add(news)
        }
        rcvRes.adapter = RcvResturantAdapter(this, newArrayList, this)

//    var adapter = hotelDetailClass(newArrayList)
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this,"hello $position", Toast.LENGTH_SHORT).show()
        var id:String=""
        var name:String=""
        var location:String=""
        var cuisine:String=""
        var price:String=""
        if(position==0){

            id="40"
            name="A RESTAURANT"
            location="Karachi"
            cuisine="desert"
            price="150"

            val intent = Intent(this, ResturantOne::class.java)
            intent.putExtra("RES_ID",id);
            intent.putExtra("RES_NAME",name);
            intent.putExtra("RES_LOC",location);
            intent.putExtra("CUISINE_TYPE",cuisine);
            intent.putExtra("RES_PRICE",price);
            startActivity(intent)

        }else if(position==1){
            id="41"
            name="B RESTAURANT"
            location="Karachi"
            cuisine="Delights"
            price="900"


            val intent = Intent(this, ResturantOne::class.java)
            intent.putExtra("RES_ID",id);
            intent.putExtra("RES_NAME",name);
            intent.putExtra("RES_LOC",location);
            intent.putExtra("CUISINE_TYPE",cuisine);
            intent.putExtra("RES_PRICE",price);
            startActivity(intent)

        }else if(position==2){
            id="42"
            name="C RESTAURANT"
            location="Karachi"
            cuisine="Delights"
            price="260"


            val intent = Intent(this, ResturantOne::class.java)
            intent.putExtra("RES_ID",id);
            intent.putExtra("RES_NAME",name);
            intent.putExtra("RES_LOC",location);
            intent.putExtra("CUISINE_TYPE",cuisine);
            intent.putExtra("RES_PRICE",price);
            startActivity(intent)

        }
        else if(position==3){
            id="43"
            name="D RESTAURANT"
            location="Karachi"
            cuisine="JAMMINGS"
            price="350"


            val intent = Intent(this, ResturantOne::class.java)
            intent.putExtra("RES_ID",id);
            intent.putExtra("RES_NAME",name);
            intent.putExtra("RES_LOC",location);
            intent.putExtra("CUISINE_TYPE",cuisine);
            intent.putExtra("RES_PRICE",price);
            startActivity(intent)

        }
        else if(position==4){
            id="44"
            name="E RESTAURANT"
            location="ISLAMABAD"
            cuisine="CUISINES"
            price="880"


            val intent = Intent(this, ResturantOne::class.java)
            intent.putExtra("RES_ID",id);
            intent.putExtra("RES_NAME",name);
            intent.putExtra("RES_LOC",location);
            intent.putExtra("CUISINE_TYPE",cuisine);
            intent.putExtra("RES_PRICE",price);
            startActivity(intent)

        }
        val clickItem = newArrayList[position]
    }
}
