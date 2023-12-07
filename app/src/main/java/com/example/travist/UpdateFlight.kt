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

class UpdateFlight : AppCompatActivity() {

    lateinit var idEdit: EditText
    lateinit var airline: EditText
    lateinit var dept_loc: EditText
    lateinit var arrive_loc: EditText
    lateinit var arrive_time: EditText
    lateinit var dept_time: EditText
    lateinit var price: EditText
    lateinit var register: Button



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_flight)

        idEdit = findViewById(R.id.id)
        airline = findViewById(R.id.airline)
        dept_loc=findViewById(R.id.dept_loc)
        dept_time=findViewById(R.id.dept_time)
        arrive_time=findViewById(R.id.arrive_time)
        arrive_loc=findViewById(R.id.arrive_loc)
        price=findViewById(R.id.price)

        register = findViewById(R.id.register)
        register.setOnClickListener {
           insert()
        }

    }

    fun insert() {
        val id: String = idEdit.text.toString().trim()
        val airline: String = airline.text.toString().trim()
        val departure_location: String = dept_loc.text.toString().trim()
        val arrival_location: String = arrive_loc.text.toString().trim()
        val departure_time: String = dept_time.text.toString().trim()
        val arrival_time: String = arrive_time.text.toString().trim()
        val price: String = price.text.toString().trim()

//        var URL: String = Conn.url + "conn.php"
        var URL: String = "https://192.168.32.194/travist/updateFlight.php"


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
                params["flight_id"] = id
                params["airline"] = airline
                params["departureLocation"] = departure_location
                params["arrivalLocation"] = arrival_location
                params["departureTime"] = departure_time
                params["arrivalTime"] = arrival_time
                params["otherFlightDetails"] = price
                return params
            }
        }

        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
    }

}
