package com.example.travist

//import android.support.v7.app.AppCompatActivity
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
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
    lateinit var uid: TextView
    lateinit var pay: ImageView

    var doubleBackPress : Boolean = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        // Retrieve user_id from the intent
        val id = intent.getStringExtra("USER_ID")
        val username = intent.getStringExtra("USER_NAME")

        // Now you can use the user_id as needed
        // For example, you can print it to the log
        Log.d("MainActivity", "User ID: $id")


        Animatoo.animateSlideUp(this)
        
        hotel_btn = findViewById(R.id.hotel_btn)
        flight_btn = findViewById(R.id.flight_btn)
        userName = findViewById(R.id.userName)
        pay = findViewById(R.id.pay)
        uid = findViewById(R.id.uid)
        resturant_btn = findViewById(R.id.resturant_btn)
        reservation_btn = findViewById(R.id.reservation_btn)

        userName.text=username
        uid.text=id

        fun onBackPressed() {
            if (doubleBackPress) {
                super.onBackPressed()
            }

            doubleBackPress = true
            Animatoo.animateSlideUp(this)
        }

        hotel_btn.setOnClickListener {

            var idu = uid.text.toString()

            Toast.makeText(this,"Hotel",Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HotelActivity::class.java)
            intent.putExtra("USER_TABLE_ID", idu)
            startActivity(intent)
            Animatoo.animateSlideLeft(this)
        }

        flight_btn.setOnClickListener {

            var idu = uid.text.toString()

            Toast.makeText(this,"Flight",Toast.LENGTH_SHORT).show()
            val intent = Intent(this, FilghtActivity::class.java)
            intent.putExtra("USER_TABLE_ID", idu)
            startActivity(intent)
            Animatoo.animateSlideLeft(this)
        }

        pay.setOnClickListener {

            var idu = uid.text.toString()

            Toast.makeText(this,"Payment",Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Payment::class.java)
            intent.putExtra("USER_TABLE_ID", idu)
            startActivity(intent)
            Animatoo.animateSlideLeft(this)
        }

        resturant_btn.setOnClickListener {

            var idu = uid.text.toString()

            Toast.makeText(this,"Resturant",Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ResturantActivity::class.java)
            intent.putExtra("USER_TABLE_ID", idu)
            startActivity(intent)
            Animatoo.animateSlideLeft(this)
        }

        reservation_btn.setOnClickListener {
            var idu = uid.text.toString()

            Toast.makeText(this,"Reservation",Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ReservationActivity::class.java)
            intent.putExtra("USER_TABLE_ID", idu)
            startActivity(intent)
            Animatoo.animateSlideLeft(this)
        }
    }


}