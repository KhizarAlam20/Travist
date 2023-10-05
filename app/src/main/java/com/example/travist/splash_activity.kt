package com.example.travist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splash_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val intent = Intent (this,MainActivity::class.java)

        Handler().postDelayed({
            startActivity(intent)
            finish()
        },5000)

    }
}