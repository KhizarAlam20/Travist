package com.example.travist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class HotelOne : AppCompatActivity() {
    lateinit var hotel_ID :TextView
    lateinit var hotel_Name:TextView
    lateinit var hotel_Location:TextView
    lateinit var hotel_Rating:TextView
    lateinit var hotel_Price:TextView
    lateinit var no_of_person:TextView
    lateinit var Decrease:Button
    lateinit var Increase: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_one)

        hotel_ID = findViewById(R.id.hotel_ID)
        hotel_Name = findViewById(R.id.hotel_Name)

        hotel_Location = findViewById(R.id.hotel_Location)
        hotel_Rating = findViewById(R.id.hotel_Rating)
        hotel_Price = findViewById(R.id.hotel_Price)

        Increase = findViewById(R.id.Increase)
        Decrease = findViewById(R.id.Decrease)
        no_of_person = findViewById(R.id.no_of_person)

        // Retrieve user_id from the intent
        val id = intent.getStringExtra("hotel_id")
        val name = intent.getStringExtra("hotel_name")
        val location = intent.getStringExtra("hotel_location")
        val rating = intent.getStringExtra("hotel_rating")
        val price = intent.getStringExtra("hotel_price")

        // Now you can use the user_id as needed
        // For example, you can print it to the log
        Log.d("MainActivity", "hotel ID: $id")

        var count:Int=1
        var initialPrice:Int=Integer.parseInt(price)

        hotel_ID.text=id
        hotel_Name.text=name
        hotel_Location.text=location
        hotel_Rating.text=rating
        hotel_Price.text=price


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
    }
}