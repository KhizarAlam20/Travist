package com.example.travist

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ResturantActivity : AppCompatActivity(), RcvResturantAdapter.OnItemClickListner {
    lateinit var rcvRes: RecyclerView
    lateinit var uid: TextView

    lateinit var res_name: Array<String>
    lateinit var newArrayList: ArrayList<ResturantDetailClass>
    lateinit var res_image: Array<Int>
    lateinit var res_price: Array<String>
    lateinit var res_description: Array<String>


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resturant)

        // Retrieve user_id from the intent
        val idu = intent.getStringExtra("USER_TABLE_ID")


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
        uid= findViewById(R.id.uid)


        uid.text=idu


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
//        var id:String=""
//        var name:String=""
//        var location:String=""
//        var cuisine:String=""
//        var price:String=""

        var rid: String = ""
        var bookingDate: String = ""
        var price: String = ""

        var user_table_id= uid.text.toString()

        if(position==0){

            rid = "40"
            bookingDate = "07 dec,2023"
            price = "400"

            val intent = Intent(this, ResturantOne::class.java)
            intent.putExtra("RES_ID", rid);
            intent.putExtra("BOOKING_DATE", bookingDate);
            intent.putExtra("RES_PRICE", price);
            intent.putExtra("userid",user_table_id);
            startActivity(intent)

        }else if(position==1){
            rid = "41"
            bookingDate = "07 dec,2023"
            price = "400"

            val intent = Intent(this, ResturantOne::class.java)
            intent.putExtra("RES_ID", rid);
            intent.putExtra("BOOKING_DATE", bookingDate);
            intent.putExtra("RES_PRICE", price);
            intent.putExtra("userid",user_table_id);
            startActivity(intent)

        }else if(position==2){
            rid = "42"
            bookingDate = "07 dec,2023"
            price = "400"

            val intent = Intent(this, ResturantOne::class.java)
            intent.putExtra("RES_ID", rid);
            intent.putExtra("BOOKING_DATE", bookingDate);
            intent.putExtra("RES_PRICE", price);
            intent.putExtra("userid",user_table_id);
            startActivity(intent)

        }
        else if(position==3){
            rid = "43"
            bookingDate = "07 dec,2023"
            price = "400"

            val intent = Intent(this, ResturantOne::class.java)
            intent.putExtra("RES_ID", rid);
            intent.putExtra("BOOKING_DATE", bookingDate);
            intent.putExtra("RES_PRICE", price);
            intent.putExtra("userid",user_table_id);
            startActivity(intent)

        }
        else if(position==4){
            rid = "44"
            bookingDate = "07 dec,2023"
            price = "400"

            val intent = Intent(this, ResturantOne::class.java)
            intent.putExtra("RES_ID", rid);
            intent.putExtra("BOOKING_DATE", bookingDate);
            intent.putExtra("RES_PRICE", price);
            intent.putExtra("userid",user_table_id);
            startActivity(intent)

        }
        val clickItem = newArrayList[position]
    }
}
