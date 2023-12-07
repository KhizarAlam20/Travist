package com.example.travist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class updateRes : AppCompatActivity() {

    lateinit var idEdit: EditText
    lateinit var name: EditText
    lateinit var location: EditText
    lateinit var cuisine_type: EditText
    lateinit var price: EditText
    lateinit var register: Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_res)

        idEdit = findViewById(R.id.id)
        name = findViewById(R.id.name)
        location=findViewById(R.id.location)
        cuisine_type=findViewById(R.id.cuisine_type)
        price=findViewById(R.id.price)

        register = findViewById(R.id.register)
        register.setOnClickListener {
            insert()
        }
    }

    fun insert() {
        val id: String = idEdit.text.toString().trim()
        val name: String = name.text.toString().trim()
        val location: String = location.text.toString().trim()
        val cuisine_type: String = cuisine_type.text.toString().trim()
        val price: String = price.text.toString().trim()

//        var URL: String = Conn.url + "conn.php"
        var URL: String = "https://192.168.32.194/travist/updateRes.php"


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
                params["restaurant_id"] = id
                params["name"] = name
                params["location"] = location
                params["cuisine_type"] = cuisine_type
                params["otherRestaurantDetails"] = price
                return params
            }
        }

        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
    }
}