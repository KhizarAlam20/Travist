package com.example.travist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class flight_one : AppCompatActivity() {
    lateinit var flight_id: TextView
    lateinit var flight_name: TextView
    lateinit var flight_departLoc: TextView
    lateinit var flight_arriveLoc: TextView
    lateinit var flight_departTime: TextView
    lateinit var flight_arriveTime: TextView
    lateinit var flight_price: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_one)


        flight_id = findViewById(R.id.flight_id)
        flight_name = findViewById(R.id.flight_name)
        flight_departLoc = findViewById(R.id.flight_departLoc)
        flight_arriveLoc = findViewById(R.id.flight_arriveLoc)
        flight_departTime = findViewById(R.id.flight_departTime)
        flight_arriveTime = findViewById(R.id.flight_arriveTime)
        flight_price = findViewById(R.id.flight_price)


        // Retrieve user_id from the intent
        val id = intent.getStringExtra("flight_ID")
        val name = intent.getStringExtra("flight_Name")
        val Dlocation = intent.getStringExtra("depart_Location")
        val Alocation = intent.getStringExtra("arrive_Location")
        val Dtime = intent.getStringExtra("depart_Time")
        val Atime = intent.getStringExtra("arrive_Time")
        val price = intent.getStringExtra("flight_Price")

        // Now you can use the user_id as needed
        // For example, you can print it to the log
        Log.d("MainActivity", "hotel ID: $id")

        var count: Int = 1
        var initialPrice: Int = Integer.parseInt(price)

        flight_id.text = id
        flight_name.text = name
        flight_departLoc.text = Dlocation
        flight_arriveLoc.text = Alocation
        flight_departTime.text = Dtime
        flight_arriveTime.text = Atime
        flight_price.text = price
    }
}