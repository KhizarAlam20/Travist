package com.example.travist

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import org.json.JSONException
import org.json.JSONObject
import java.security.SecureRandom
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


class LoginActivity : AppCompatActivity() {
    lateinit var btn_login: Button
    lateinit var uid: EditText
    lateinit var password: EditText
    lateinit var signup_btn: TextView

    //    var url: String = "https://192.168.10.4/travist/"
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        try {
            val trustAllCerts: Array<TrustManager> = arrayOf(
                object : X509TrustManager {
                    override fun checkClientTrusted(
                        chain: Array<out java.security.cert.X509Certificate>?,
                        authType: String?
                    ) {
                    }

                    override fun checkServerTrusted(
                        chain: Array<out java.security.cert.X509Certificate>?,
                        authType: String?
                    ) {
                    }

                    override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> {
                        return arrayOf()
                    }
                }
            )

            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())

            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.socketFactory)
            HttpsURLConnection.setDefaultHostnameVerifier { _, _ -> true }

        } catch (e: Exception) {
            e.printStackTrace()
        }


        btn_login = findViewById(R.id.btn_login)
        uid = findViewById(R.id.uid)
        password = findViewById(R.id.password)
        signup_btn = findViewById(R.id.signup_btn)

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

        signup_btn.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            Animatoo.animateSlideLeft(this)
        }


    }

    private fun showError(uid: EditText, s: String) {

        uid.setError(s)
        uid.requestFocus()

    }


    fun login() {

        val uid: String = uid.text.toString()
        val password: String = password.text.toString()


//        var URLL: String = Conn.url + "display.php"
        var URLL: String ="https://192.168.10.5/travist/display.php"

        val request = StringRequest(Request.Method.POST, URLL,
            Response.Listener<String> { response ->
                Log.d("Response", response)
                Log.d("Before success", response)
//                arrayListEmployee.clear()
                try {
                    var jsonObject = JSONObject(response)
                    var success = jsonObject.getString("success")
                    var jsonArray = jsonObject.getJSONArray("user")

                    println(success + " <- success from .php")
                    Log.d("hello -------------------------", response)
                    Log.d("Before success", success)

                    if (success == "1") {
                        Log.d("hello -------------------------", response)

                        for (i in 0 until jsonArray.length()) {
                            val obj = jsonArray.getJSONObject(i)

                            val user_id = obj.getString("user_id")
                            val username = obj.getString("username")
                            val Password = obj.getString("password")
                            val email = obj.getString("email")
                            val other_user_details = obj.getString("other_user_details")

                            if (user_id.equals(uid) && Password.equals(password)) {
                                Toast.makeText(
                                    this@LoginActivity,
                                    "Hello logged in",
                                    Toast.LENGTH_SHORT
                                ).show()
                                val intent = Intent(this, MainActivity::class.java)
                                intent.putExtra("USER_ID", user_id)
                                intent.putExtra("USER_NAME", username)// Add the user_id as an extra
                                startActivity(intent)
                                Animatoo.animateSlideLeft(this)
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
                Toast.makeText(this@LoginActivity, error.message, Toast.LENGTH_SHORT).show()
            })

        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(request)
    }

}