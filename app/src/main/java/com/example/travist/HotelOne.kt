package com.example.travist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.insert
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class HotelOne : AppCompatActivity() {
    lateinit var hotel_ID :TextView
    lateinit var hotel_Name:TextView
    lateinit var hotel_Price:TextView
    lateinit var user_id_val: TextView
    lateinit var no_of_person:TextView
    lateinit var Decrease:Button
    lateinit var Increase: Button
    lateinit var save: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_one)

        hotel_ID = findViewById(R.id.hotel_ID)
        user_id_val = findViewById(R.id.user_id_val)
        hotel_Name = findViewById(R.id.hotel_Name)
        save = findViewById(R.id.save)

//        hotel_Location = findViewById(R.id.hotel_Location)
//        hotel_Rating = findViewById(R.id.hotel_Rating)
        hotel_Price = findViewById(R.id.hotel_Price)

        Increase = findViewById(R.id.Increase)
        Decrease = findViewById(R.id.Decrease)
        no_of_person = findViewById(R.id.no_of_person)

        // Retrieve user_id from the intent
        val uid = intent.getStringExtra("userid")
        val hid = intent.getStringExtra("hotel_id")
        val name = intent.getStringExtra("booking_date")
//        val location = intent.getStringExtra("hotel_location")
//        val rating = intent.getStringExtra("hotel_rating")
        val price = intent.getStringExtra("hotel_price")


        // Now you can use the user_id as needed
        // For example, you can print it to the log
        Log.d("MainActivity", "hotel ID: $hid")

        var count:Int=1
        var initialPrice:Int=Integer.parseInt(price)

        hotel_ID.text=hid
        hotel_Name.text=name
        hotel_Price.text=price
        user_id_val.text=uid


//        hotel_Location.text=location
//        hotel_Rating.text=rating


        Increase.setOnClickListener {
            var value:Int = Integer.parseInt(no_of_person.text.toString())
            var updateValue:Int = value+count


            var priceValue:Int =Integer.parseInt(hotel_Price.text.toString())

            var updatePriceValue:Int = initialPrice * updateValue
            var priceToShow:String = Integer.toString(updatePriceValue)

            no_of_person.text=Integer.toString(updateValue)
            hotel_Price.text=priceToShow
        }

        var priceToShow: String=""
        Decrease.setOnClickListener {
            var value: Int = Integer.parseInt(no_of_person.text.toString())
            if (value > 1) {
                var updateValue: Int = value - count
                no_of_person.text = Integer.toString(updateValue)

                var priceValue: Int = Integer.parseInt(hotel_Price.text.toString())

                var updatePriceValue: Int = priceValue - initialPrice

                // Ensure that the updated price is at least the initial price
                if (updatePriceValue >= initialPrice) {
                    hotel_Price.text = Integer.toString(updatePriceValue)
                } else {
                    hotel_Price.text = Integer.toString(initialPrice)
                }

            } else {
                Toast.makeText(this, "At least 1 member mandatory", Toast.LENGTH_SHORT).show()
            }
        }

        save.setOnClickListener {
           insert()
        }
    }


    fun insert() {
        val idValue: String = hotel_ID.text.toString().trim()
        val nameValue: String = hotel_Name.text.toString().trim()
        val otherHotelDetailsValue: String = hotel_Price.text.toString().trim()
        val userIdValue: String = user_id_val.text.toString().trim()

        var URL: String = "https://192.168.10.5/travist/hotelBooking.php"


        println("Hello After")

        val stringRequest = object : StringRequest(
            Request.Method.POST, URL,
            Response.Listener { response ->
                if (response.equals("inserted", ignoreCase = true)) {
                    Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, response, Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener { error ->
                Toast.makeText(this, error.message + " | " + URL, Toast.LENGTH_SHORT).show()

            }
        ) {
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["user_id"] = userIdValue
                params["hotel_id"] = idValue
                params["booking_date"] = nameValue
                params["other_booking_details"] = otherHotelDetailsValue
                return params
            }
        }

        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
    }
}