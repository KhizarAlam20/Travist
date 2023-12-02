package com.example.travist.hotel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.travist.HotelOne
import com.example.travist.R

class HotelActivity : AppCompatActivity(), rcvAdapter.OnItemClickListner {
    lateinit var rcv : RecyclerView
    lateinit var hotel_name :Array<String>
    lateinit var newArrayList : ArrayList<hotelDetailClass>
    lateinit var hotel_image :Array<Int>
    lateinit var hotel_price :Array<String>
    lateinit var hotel_description :Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel)

        hotel_image = arrayOf(
            R.drawable.h1,
            R.drawable.h2,
            R.drawable.h3,
            R.drawable.h4,
            R.drawable.h5
        )

        hotel_name = arrayOf(
            "Hotel A",
            "Hotel B",
            "Hotel C",
            "Hotel D",
            "Hotel E",
        )

        hotel_price = arrayOf(
            "$200",
            "$900",
            "$260",
            "$350",
            "$880",
        )

        hotel_description = arrayOf(
            "New york",
            "London",
            "England",
            "Pakistan",
            "India",
        )

        rcv = findViewById(R.id.rcv)


    //
//        listCategories= ArrayList<hotelDetailClass>()
//        listCategories.add(hotelDetailClass("Hotel A","New York","$200",R.drawable.hotairballons))
//        listCategories.add(hotelDetailClass("Hotel B","Canada","$250",R.drawable.hotairballons))
//
        rcv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        newArrayList= arrayListOf<hotelDetailClass>()

        getUserData()

//        rcv.adapter = rcvAdapter(this,listCategories)

    }

    private fun getUserData() {
        for (i in hotel_image.indices){
            val news = hotelDetailClass(hotel_name[i],hotel_description[i],hotel_price[i],hotel_image[i])
            newArrayList.add(news)
        }
        rcv.adapter = rcvAdapter(this, newArrayList,this)

//    var adapter = hotelDetailClass(newArrayList)
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this,"hello $position",Toast.LENGTH_SHORT).show()

        var id:String=""
        var name:String=""
        var location:String=""
        var rating:String=""
        var price:String=""
        if(position==0){

            id="20"
            name="A hotel"
            location="Karachi"
            rating="5"
            price="200"

            val intent = Intent(this, HotelOne::class.java)
            intent.putExtra("hotel_id",id);
            intent.putExtra("hotel_name",name);
            intent.putExtra("hotel_location",location);
            intent.putExtra("hotel_rating",rating);
            intent.putExtra("hotel_price",price);
            startActivity(intent)

        }else if(position==1){
            id="21"
            name="B Hotel"
            location="Islamabad"
            rating="4"
            price="900"

            val intent = Intent(this, HotelOne::class.java)
            intent.putExtra("hotel_id",id);
            intent.putExtra("hotel_name",name);
            intent.putExtra("hotel_location",location);
            intent.putExtra("hotel_rating",rating);
            intent.putExtra("hotel_price",price);
            startActivity(intent)

        }else if(position==2){
            id="22"
            name="C hotel"
            location="Karachi"
            rating="4"
            price="260"

            val intent = Intent(this, HotelOne::class.java)
            intent.putExtra("hotel_id",id);
            intent.putExtra("hotel_name",name);
            intent.putExtra("hotel_location",location);
            intent.putExtra("hotel_rating",rating);
            intent.putExtra("hotel_price",price);
            startActivity(intent)

        }else if(position==3){
            id="23"
            name="D hotel"
            location="Lahore"
            rating="5"
            price="350"

            val intent = Intent(this, HotelOne::class.java)
            intent.putExtra("hotel_id",id);
            intent.putExtra("hotel_name",name);
            intent.putExtra("hotel_location",location);
            intent.putExtra("hotel_rating",rating);
            intent.putExtra("hotel_price",price);
            startActivity(intent)
        }else{
            id="24"
            name="E hotel"
            location="Karachi"
            rating="5"
            price="880"

            val intent = Intent(this, HotelOne::class.java)
            intent.putExtra("hotel_id",id);
            intent.putExtra("hotel_name",name);
            intent.putExtra("hotel_location",location);
            intent.putExtra("hotel_rating",rating);
            intent.putExtra("hotel_price",price);
            startActivity(intent)
        }


        val clickItem = newArrayList[position]
    }
}