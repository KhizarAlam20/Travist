package com.example.travist

import android.annotation.SuppressLint
import android.content.Intent
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
        var id:String=""
        var name:String=""
        var Dlocation:String=""
        var Alocation:String=""
        var Dtime:String=""
        var Atime:String=""
        var price:String=""

        if(position==0){

            id="30"
            name="A Flight"
            Dlocation="Karachi"
            Alocation="China"
            Dtime="12.30"
            Atime="1.30"
            price="150"

            val intent = Intent(this, flight_one::class.java)
            intent.putExtra("flight_ID",id);
            intent.putExtra("flight_Name",name);
            intent.putExtra("depart_Location",Dlocation);
            intent.putExtra("arrive_Location",Alocation);
            intent.putExtra("depart_Time",Dtime);
            intent.putExtra("arrive_Time",Atime);
            intent.putExtra("flight_Price",price);
            startActivity(intent)

        }else if(position==1){

            id="31"
            name="B Flight"
            Dlocation="Karachi"
            Alocation="America"
            Dtime="12.00"
            Atime="13.30"
            price="900"

            val intent = Intent(this, flight_one::class.java)
            intent.putExtra("flight_ID",id);
            intent.putExtra("flight_Name",name);
            intent.putExtra("depart_Location",Dlocation);
            intent.putExtra("arrive_Location",Alocation);
            intent.putExtra("depart_Time",Dtime);
            intent.putExtra("arrive_Time",Atime);
            intent.putExtra("flight_Price",price);
            startActivity(intent)

        }else if(position==2){

            id="32"
            name="C Flight"
            Dlocation="Karachi"
            Alocation="America"
            Dtime="12.00"
            Atime="13.30"
            price="900"

            val intent = Intent(this, flight_one::class.java)
            intent.putExtra("flight_ID",id);
            intent.putExtra("flight_Name",name);
            intent.putExtra("depart_Location",Dlocation);
            intent.putExtra("arrive_Location",Alocation);
            intent.putExtra("depart_Time",Dtime);
            intent.putExtra("arrive_Time",Atime);
            intent.putExtra("flight_Price",price);
            startActivity(intent)

        }else if(position==3){

            id="33"
            name="D Flight"
            Dlocation="Karachi"
            Alocation="America"
            Dtime="12.00"
            Atime="13.30"
            price="900"

            val intent = Intent(this, flight_one::class.java)
            intent.putExtra("flight_ID",id);
            intent.putExtra("flight_Name",name);
            intent.putExtra("depart_Location",Dlocation);
            intent.putExtra("arrive_Location",Alocation);
            intent.putExtra("depart_Time",Dtime);
            intent.putExtra("arrive_Time",Atime);
            intent.putExtra("flight_Price",price);
            startActivity(intent)

        }else if(position==4){

            id="34"
            name="E Flight"
            Dlocation="Karachi"
            Alocation="America"
            Dtime="12.00"
            Atime="13.30"
            price="900"

            val intent = Intent(this, flight_one::class.java)
            intent.putExtra("flight_ID",id);
            intent.putExtra("flight_Name",name);
            intent.putExtra("depart_Location",Dlocation);
            intent.putExtra("arrive_Location",Alocation);
            intent.putExtra("depart_Time",Dtime);
            intent.putExtra("arrive_Time",Atime);
            intent.putExtra("flight_Price",price);
            startActivity(intent)

        }

        val clickItem = newArrayList[position]
    }
}
