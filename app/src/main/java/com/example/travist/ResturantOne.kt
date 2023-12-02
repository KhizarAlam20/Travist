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

class ResturantOne : AppCompatActivity() {
    lateinit var resturant_id: TextView
    lateinit var resturant_name: TextView
    lateinit var resturant_location: TextView
    lateinit var cuisine_type: TextView
    lateinit var resturant_price: TextView
    lateinit var no_of_person: TextView
    lateinit var decrease: Button
    lateinit var increase: Button
    lateinit var save: Button
    lateinit var back: Button
    var saveCount: Int = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resturant_one)

        resturant_id = findViewById(R.id.resturant_id)
        resturant_name = findViewById(R.id.resturant_name)

        resturant_location = findViewById(R.id.resturant_location)
        cuisine_type = findViewById(R.id.cuisine_type)
        resturant_price = findViewById(R.id.resturant_price)

        increase = findViewById(R.id.increase)
        decrease = findViewById(R.id.decrease)
        no_of_person = findViewById(R.id.no_of_person)

        save = findViewById(R.id.save)
        back = findViewById(R.id.back)

        // Retrieve user_id from the intent
        val id = intent.getStringExtra("RES_ID")
        val name = intent.getStringExtra("RES_NAME")
        val location = intent.getStringExtra("RES_LOC")
        val cuisine = intent.getStringExtra("CUISINE_TYPE")
        val price = intent.getStringExtra("RES_PRICE")

        // Now you can use the user_id as needed
        // For example, you can print it to the log
        Log.d("MainActivity", "hotel ID: $id")

        var count: Int = 1
        var initialPrice: Int = Integer.parseInt(price)

        resturant_id.text = id
        resturant_name.text = name
        resturant_location.text = location
        cuisine_type.text = cuisine
        resturant_price.text = price

        increase.setOnClickListener {
            var value: Int = Integer.parseInt(no_of_person.text.toString())
            var updateValue: Int = value + count


            var priceValue: Int = Integer.parseInt(resturant_price.text.toString())

            var updatePriceValue: Int = initialPrice * updateValue
            var priceToShow: String = Integer.toString(updatePriceValue)

            no_of_person.text = Integer.toString(updateValue)
            resturant_price.text = priceToShow
        }

        var priceToShow: String = ""
        decrease.setOnClickListener {
            var value: Int = Integer.parseInt(no_of_person.text.toString())
            if (value > 1) {
                var updateValue: Int = value - count
                no_of_person.text = Integer.toString(updateValue)

                var priceValue: Int = Integer.parseInt(resturant_price.text.toString())

                var updatePriceValue: Int = priceValue - initialPrice

                // Ensure that the updated price is at least the initial price
                if (updatePriceValue >= initialPrice) {
                    resturant_price.text = Integer.toString(updatePriceValue)
                } else {
                    resturant_price.text = Integer.toString(initialPrice)
                }

            } else {
                Toast.makeText(this, "At least 1 member mandatory", Toast.LENGTH_SHORT).show()
            }
        }




        if (saveCount==0) {
           saveCount=1
            save.setOnClickListener {
                insert()
            }
        }else{
            Toast.makeText(this, "You already saved the record!!!", Toast.LENGTH_SHORT).show()
        }
    }

    fun insert() {
        val idValue: String = resturant_id.text.toString().trim()
        val nameValue: String = resturant_name.text.toString().trim()
        val locationValue: String = resturant_location.text.toString().trim()
        val cuisineValue: String = cuisine_type.text.toString().trim()
        val otherRestaurantDetailsValue: String = resturant_price.text.toString().trim()
        var URL: String = Conn.url + "restuarants.php"

//        if (passwordValue.isEmpty()) {
//            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show()
//            return
//        }

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
                params["restaurant_id"] = idValue
                params["name"] = nameValue
                params["location"] = locationValue
                params["cuisine_type"] = cuisineValue
                params["other_restaurant_details"] = otherRestaurantDetailsValue
                return params
            }
        }

        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
    }
}