package com.example.travist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class flight_one : AppCompatActivity() {
    lateinit var flight_id: TextView
    lateinit var booking_date: TextView
    lateinit var user_id_val: TextView
    lateinit var flight_price: TextView
    lateinit var save: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_one)


        flight_id = findViewById(R.id.flight_id)
        booking_date = findViewById(R.id.booking_date)
        user_id_val = findViewById(R.id.user_id_val)
        flight_price = findViewById(R.id.flight_price)
        save = findViewById(R.id.save)


        val uid = intent.getStringExtra("userid")


        // Retrieve user_id from the intent
        val id = intent.getStringExtra("flight_ID")
        val date = intent.getStringExtra("bookingDate")
        val price = intent.getStringExtra("flight_Price")

        // Now you can use the user_id as needed
        // For example, you can print it to the log
        Log.d("MainActivity", "hotel ID: $id")

        var count: Int = 1
        var initialPrice: Int = Integer.parseInt(price)

        flight_id.text = id
        booking_date.text = date
        flight_price.text = price
        user_id_val.text=uid

        save.setOnClickListener {
            insert()
        }

    }

    fun insert() {
        val idValue: String = flight_id.text.toString().trim()
        val nameValue: String = booking_date.text.toString().trim()
        val otherFlightDetailsValue: String = flight_price.text.toString().trim()
        val userIdValue: String = user_id_val.text.toString().trim()

        var URL: String = Conn.url+"flightBooking.php"


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
                params["flight_id"] = idValue
                params["booking_date"] = nameValue
                params["other_booking_details"] = otherFlightDetailsValue
                return params
            }
        }

        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
    }
}