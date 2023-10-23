package com.example.travist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.travist.databinding.ActivityMainBinding

class HotelActivity : AppCompatActivity() {
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
            R.drawable.hotairballons,
            R.drawable.hotairballons,
            R.drawable.hotairballons,
            R.drawable.hotairballons,
            R.drawable.hotairballons
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
            "$20",
            "$260",
            "$30",
            "$280",
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
        rcv.adapter = rcvAdapter(this,newArrayList)

    }
}