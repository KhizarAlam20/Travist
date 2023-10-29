package com.example.travist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.travist.hotel.hotelDetailClass
import com.example.travist.hotel.rcvAdapter

class FilghtActivity : AppCompatActivity(), RcvFlightAdapter.OnItemClickListner {
    lateinit var rcvFlight: RecyclerView
    lateinit var flight_name: Array<String>
    lateinit var newArrayList: ArrayList<FlightDetailClass>
    lateinit var flight_image: Array<Int>
    lateinit var flight_price: Array<String>
    lateinit var flight_description: Array<String>


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filght)

        flight_image = arrayOf(
            R.drawable.h1,
            R.drawable.h2,
            R.drawable.h3,
            R.drawable.h4,
            R.drawable.h5
        )

        flight_name = arrayOf(
            "FLIGHT A",
            "FLIGHT B",
            "FLIGHT C",
            "FLIGHT D",
            "FLIGHT E",
        )

        flight_price = arrayOf(
            "$150",
            "$900",
            "$260",
            "$350",
            "$880",
        )

        flight_description = arrayOf(
            "Asian Flights",
            "North American",
            "Europe",
            "Southern Flight",
            "African Flights",
        )

        rcvFlight = findViewById(R.id.rcvFlight)

        rcvFlight.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        newArrayList = arrayListOf<FlightDetailClass>()

        getUserData()

//        rcv.adapter = rcvAdapter(this,listCategories)

    }

    private fun getUserData() {
        for (i in flight_image.indices) {
            val news = FlightDetailClass(
                flight_name[i],
                flight_description[i],
                flight_price[i],
                flight_image[i]
            )
            newArrayList.add(news)
        }
        rcvFlight.adapter = RcvFlightAdapter(this, newArrayList, this)

//    var adapter = hotelDetailClass(newArrayList)
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this,"hello $position", Toast.LENGTH_SHORT).show()
        val clickItem = newArrayList[position]
    }
}
