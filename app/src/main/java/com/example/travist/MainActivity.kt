package com.example.travist

//import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.travist.hotel.HotelActivity

class MainActivity : AppCompatActivity() {

    lateinit var flight_btn: CardView
    lateinit var hotel_btn: CardView
    lateinit var resturant_btn: CardView
    lateinit var reservation_btn: CardView
    lateinit var userName: TextView
    var doubleBackPress : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        // Retrieve user_id from the intent
        val user_id = intent.getStringExtra("USER_ID")

        // Now you can use the user_id as needed
        // For example, you can print it to the log
        Log.d("MainActivity", "User ID: $user_id")


        Animatoo.animateSlideUp(this)
        
        hotel_btn = findViewById(R.id.hotel_btn)
        flight_btn = findViewById(R.id.flight_btn)
        userName = findViewById(R.id.userName)
        resturant_btn = findViewById(R.id.resturant_btn)
        reservation_btn = findViewById(R.id.reservation_btn)

        userName.text=user_id

        fun onBackPressed() {
            if (doubleBackPress) {
                super.onBackPressed()
            }

            doubleBackPress = true
            Animatoo.animateSlideUp(this)
        }

        hotel_btn.setOnClickListener {
            Toast.makeText(this,"Hotel",Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HotelActivity::class.java)
            startActivity(intent)
            Animatoo.animateSlideLeft(this)
        }

        flight_btn.setOnClickListener {
            Toast.makeText(this,"Flight",Toast.LENGTH_SHORT).show()
            val intent = Intent(this, FilghtActivity::class.java)
            startActivity(intent)
            Animatoo.animateSlideLeft(this)
        }

        resturant_btn.setOnClickListener {
            Toast.makeText(this,"Resturant",Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ResturantActivity::class.java)
            startActivity(intent)
            Animatoo.animateSlideLeft(this)
        }

        reservation_btn.setOnClickListener {
            Toast.makeText(this,"Reservation",Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ReservationActivity::class.java)
            startActivity(intent)
            Animatoo.animateSlideLeft(this)
        }
    }


}