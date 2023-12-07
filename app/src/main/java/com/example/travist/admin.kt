package com.example.travist

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import org.json.JSONException
import org.json.JSONObject

class admin : AppCompatActivity() {

    lateinit var btn_login: Button
    lateinit var signup_btn: TextView
    lateinit var btn_admin: Button
    lateinit var uid: EditText
    lateinit var password: EditText


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        btn_login = findViewById(R.id.btn_login)
        uid = findViewById(R.id.uid)
        password = findViewById(R.id.password)

        signup_btn=findViewById(R.id.signup_btn)
        btn_login.setOnClickListener {

//            if (uid.text.toString().isEmpty()) {
//                showError(uid, "Enter User ID")
//            }else if(password.text.toString().isEmpty()){
//                showError(password, "Enter Password")
//            }
//
//            else {
            login()
//            }
        }


    }

    private fun showError(uid: EditText, s: String) {

        uid.setError(s)
        uid.requestFocus()

    }


   public  fun login() {

        val uid: String = uid.text.toString()
        val password: String = password.text.toString()
       Toast.makeText(
           this@admin,
           "Tapped",
           Toast.LENGTH_SHORT
       ).show()

//        var URLL: String = Conn.url + "display.php"
        var URLL: String ="https://192.168.32.194/travist/admin.php"

        val request = StringRequest(
            Request.Method.POST, URLL,
            Response.Listener<String> { response ->
                Log.d("Response", response)
                Log.d("Before success", response)
//                arrayListEmployee.clear()
                try {
                    var jsonObject = JSONObject(response)
                    var success = jsonObject.getString("success")
                    var jsonArray = jsonObject.getJSONArray("admin")

                    println(success + " <- success from .php")
                    Log.d("hello -------------------------", response)
                    Log.d("Before success", success)

                    if (success == "1") {
                        Log.d("hello -------------------------", response)

                        for (i in 0 until jsonArray.length()) {
                            val obj = jsonArray.getJSONObject(i)

                            val admin_id = obj.getString("admin_id")
                            val username = obj.getString("username")
                            val Password = obj.getString("password")
                            val email = obj.getString("email")
                            val other_admin_details = obj.getString("other_admin_details")

                            signup_btn.text=admin_id

                            if (admin_id.equals(uid) && Password.equals(password)) {
                                Toast.makeText(
                                    this@admin,
                                    "Hello logged in",
                                    Toast.LENGTH_SHORT
                                ).show()
                                val intent = Intent(this, AdminPanel::class.java)
                                intent.putExtra("USER_ID", admin_id)
                                intent.putExtra("USER_NAME", username)// Add the user_id as an extra
                                startActivity(intent)
                                Animatoo.animateSlideLeft(this)
                            }else{
                                Toast.makeText(
                                    this@admin,
                                    "Admin ID = "+admin_id+" | Password = "+password,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
//                            perf.text = name
//                            val employee = employees(id, name, email, password)
//                            arrayListEmployee.add(employee)
//                            listAdapter.notifyDataSetChanged()
                        }
                    } else {
                        // Handle the error condition
                        Log.d("Error", "Failed to retrieve data")
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { error ->
                Toast.makeText(this@admin, error.message, Toast.LENGTH_SHORT).show()
            })

        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(request)
    }
}