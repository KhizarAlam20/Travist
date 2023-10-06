package com.example.travist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    lateinit var btn_login: Button
    lateinit var name: EditText
    lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btn_login = findViewById(R.id.btn_login)
        name = findViewById(R.id.name)
        password = findViewById(R.id.password)

        btn_login.setOnClickListener {

            var Name : String = name.text.toString()
            var Password : String = password.text.toString()

            println(Name + "t" + Password)

            if(Name.equals("khizar") && Password.equals("alam")) {
                var intent = Intent(this, SignupActivity::class.java)
                startActivity(intent)
            }else{
                if(!Name.equals("khizar")){
                    Toast.makeText(this,"name error",Toast.LENGTH_SHORT).show()
                }else if(!Password.equals("alam")){
                    Toast.makeText(this,"Pass error",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"cant identify",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}