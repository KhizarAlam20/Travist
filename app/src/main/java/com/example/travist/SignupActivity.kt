package com.example.travist

//import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.security.SecureRandom
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

class SignupActivity : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var other_user_details: EditText
    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var register: Button



    var url: String = "https://192.168.10.6/travist/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        //add these to skip/add all certs
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



        email = findViewById(R.id.email)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        other_user_details = findViewById(R.id.other_user_details)
        register = findViewById(R.id.register)


        register.setOnClickListener {
            insert()
        }
    }

    fun insert() {
        val nameValue: String = username.text.toString().trim()
        val emailValue: String = email.text.toString().trim()
        val passwordValue: String = password.text.toString().trim()
        val otherUserDetailsValue: String = other_user_details.text.toString().trim()
        var URL: String = url + "conn.php"

        if (passwordValue.isEmpty()) {
            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show()
            return
        }

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
                params["name"] = nameValue
                params["email"] = emailValue
                params["password"] = passwordValue
                params["other_user_details"] = otherUserDetailsValue
                return params
            }
        }

        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
    }
}