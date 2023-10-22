package com.example.travist

//import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.travist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var flight_btn: CardView
    lateinit var hotel_btn: CardView
    lateinit var resturant_btn: CardView
    lateinit var reservation_btn: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        hotel_btn = findViewById(R.id.hotel_btn)
        flight_btn = findViewById(R.id.flight_btn)
        resturant_btn = findViewById(R.id.resturant_btn)
        reservation_btn = findViewById(R.id.reservation_btn)

        hotel_btn.setOnClickListener {
            Toast.makeText(this,"Hotel",Toast.LENGTH_SHORT).show()
            val intent = Intent(this,HotelActivity::class.java)
            startActivity(intent)
        }

        flight_btn.setOnClickListener {
            Toast.makeText(this,"Flight",Toast.LENGTH_SHORT).show()
        }

        resturant_btn.setOnClickListener {
            Toast.makeText(this,"Resturant",Toast.LENGTH_SHORT).show()
        }

        reservation_btn.setOnClickListener {
            Toast.makeText(this,"Reservation",Toast.LENGTH_SHORT).show()
        }
    }


}