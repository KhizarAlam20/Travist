package com.example.travist

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.travist.hotel.hotelDetailClass
import com.example.travist.hotel.rcvAdapter

class FilghtActivity : AppCompatActivity(), RcvFlightAdapter.OnItemClickListner {
    lateinit var rcvFlight: RecyclerView
    lateinit var uid: TextView

    lateinit var flight_name: Array<String>
    lateinit var newArrayList: ArrayList<FlightDetailClass>
    lateinit var flight_image: Array<Int>
    lateinit var flight_price: Array<String>
    lateinit var flight_description: Array<String>


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filght)


        // Retrieve user_id from the intent
        val idu = intent.getStringExtra("USER_TABLE_ID")

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
        uid= findViewById(R.id.uid)


        uid.text=idu


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
        Toast.makeText(this, "hello $position", Toast.LENGTH_SHORT).show()
        var fid: String = ""
        var bookingDate: String = ""
        var price: String = ""
        var user_table_id= uid.text.toString()


        if (position == 0) {

            fid = "30"
            bookingDate = "07 dec,2023"
            price = "400"

            val intent = Intent(this, flight_one::class.java)
            intent.putExtra("flight_ID", fid);
            intent.putExtra("bookingDate", bookingDate);
            intent.putExtra("flight_Price", price);
            intent.putExtra("userid",user_table_id);
            startActivity(intent)

        } else if (position == 1) {

            fid = "31"
            bookingDate = "06 dec,2023"
            price = "250"

            val intent = Intent(this, flight_one::class.java)
            intent.putExtra("flight_ID", fid);
            intent.putExtra("bookingDate", bookingDate);
            intent.putExtra("flight_Price", price);
            intent.putExtra("userid",user_table_id);
            startActivity(intent)

        } else if (position == 2) {

            fid = "32"
            bookingDate = "12 dec,2023"
            price = "100"

            val intent = Intent(this, flight_one::class.java)
            intent.putExtra("flight_ID", fid);
            intent.putExtra("bookingDate", bookingDate);
            intent.putExtra("flight_Price", price);
            intent.putExtra("userid",user_table_id);
            startActivity(intent)

        } else if (position == 3) {

            fid = "33"
            bookingDate = "01 dec,2023"
            price = "219"

            val intent = Intent(this, flight_one::class.java)
            intent.putExtra("flight_ID", fid);
            intent.putExtra("bookingDate", bookingDate);
            intent.putExtra("flight_Price", price);
            intent.putExtra("userid",user_table_id);
            startActivity(intent)

        } else if (position == 4) {

            fid = "33"
            bookingDate = "4 dec,2023"
            price = "209"

            val intent = Intent(this, flight_one::class.java)
            intent.putExtra("flight_ID", fid);
            intent.putExtra("bookingDate", bookingDate);
            intent.putExtra("flight_Price", price);
            intent.putExtra("userid",user_table_id);
            startActivity(intent)
        }

        val clickItem = newArrayList[position]
    }
}
