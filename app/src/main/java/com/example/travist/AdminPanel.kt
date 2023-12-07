package com.example.travist

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.blogspot.atifsoftwares.animatoolib.Animatoo

class AdminPanel : AppCompatActivity() {

    lateinit var update_flight: Button
    lateinit var update_hotel: Button
    lateinit var update_restaurants: Button
    lateinit var del_id: Button

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_panel)

    update_flight = findViewById(R.id.update_flight)
    update_hotel = findViewById(R.id.update_hotel)
    update_restaurants = findViewById(R.id.update_restaurants)
    del_id = findViewById(R.id.del_id)


        update_flight.setOnClickListener {
            val intent = Intent(this, UpdateFlight::class.java)
            startActivity(intent)
            Animatoo.animateFade(this)
        }


        update_hotel.setOnClickListener {
            val intent = Intent(this, UpdateHotel::class.java)
            startActivity(intent)
            Animatoo.animateFade(this)
        }

        update_restaurants.setOnClickListener {
            val intent = Intent(this, updateRes::class.java)
            startActivity(intent)
            Animatoo.animateFade(this)
        }

    }
}