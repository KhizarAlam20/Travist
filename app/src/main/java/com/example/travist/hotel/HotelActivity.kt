package com.example.travist.hotel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.travist.HotelOne
import com.example.travist.R
import com.example.travist.flight_one

class HotelActivity : AppCompatActivity(), rcvAdapter.OnItemClickListner {
    lateinit var rcv : RecyclerView
    lateinit var hotel_name :Array<String>
    lateinit var newArrayList : ArrayList<hotelDetailClass>
    lateinit var hotel_image :Array<Int>
    lateinit var hotel_price :Array<String>
    lateinit var hotel_description :Array<String>
    lateinit var uid: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel)


        // Retrieve user_id from the intent
        val idu = intent.getStringExtra("USER_TABLE_ID")



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
        uid= findViewById(R.id.uid)


        uid.text=idu

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

        var hid: String = ""
        var bookingDate: String = ""
        var price: String = ""
        var user_table_id= uid.text.toString()

        if(position==0){

            hid = "20"
            bookingDate = "07 dec,2023"
            price = "400"

            val intent = Intent(this, HotelOne::class.java)
            intent.putExtra("hotel_id", hid);
            intent.putExtra("booking_date", bookingDate);
            intent.putExtra("hotel_price", price);
            intent.putExtra("userid",user_table_id);
            startActivity(intent)

        }else if(position==1){
            hid = "21"
            bookingDate = "07 dec,2023"
            price = "400"

            val intent = Intent(this, HotelOne::class.java)
            intent.putExtra("hotel_id", hid);
            intent.putExtra("booking_date", bookingDate);
            intent.putExtra("hotel_price", price);
            intent.putExtra("userid",user_table_id);
            startActivity(intent)

        }else if(position==2){
            hid = "22"
            bookingDate = "07 dec,2023"
            price = "400"

            val intent = Intent(this, HotelOne::class.java)
            intent.putExtra("hotel_id", hid);
            intent.putExtra("booking_date", bookingDate);
            intent.putExtra("hotel_price", price);
            intent.putExtra("userid",user_table_id);
            startActivity(intent)

        }else if(position==3){
            hid = "23"
            bookingDate = "07 dec,2023"
            price = "400"

            val intent = Intent(this, HotelOne::class.java)
            intent.putExtra("hotel_id", hid);
            intent.putExtra("booking_date", bookingDate);
            intent.putExtra("hotel_price", price);
            intent.putExtra("userid",user_table_id);
            startActivity(intent)

        }else{
            hid = "24"
            bookingDate = "07 dec,2023"
            price = "400"

            val intent = Intent(this, HotelOne::class.java)
            intent.putExtra("hotel_id", hid);
            intent.putExtra("booking_date", bookingDate);
            intent.putExtra("hotel_price", price);
            intent.putExtra("userid",user_table_id);
            startActivity(intent)

        }


        val clickItem = newArrayList[position]
    }
}