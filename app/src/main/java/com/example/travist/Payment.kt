package com.example.travist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Payment : AppCompatActivity() {

    lateinit var res_bill: TextView
    lateinit var hotel_bill: TextView
    lateinit var flight_bill: TextView
    lateinit var uid: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        res_bill = findViewById(R.id.res_bill)
        hotel_bill = findViewById(R.id.hotel_bill)
        flight_bill = findViewById(R.id.flight_bill)
        uid = findViewById(R.id.uid)

        val id = intent.getStringExtra("USER_ID")


        res_bill.text= Pay.resBill.toString()
        hotel_bill.text= Pay.hotelBill.toString()
        flight_bill.text= Pay.flightBill.toString()
        uid.text=id

    }
}