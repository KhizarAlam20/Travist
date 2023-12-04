package com.example.travist

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException

class ReservationActivity : AppCompatActivity() {
    lateinit var etUID: EditText
    lateinit var checkOne: CheckBox
    lateinit var checkTwo: CheckBox
    lateinit var checkThree: CheckBox
//    lateinit var checkFour: CheckBox
    lateinit var btnRes: Button



    //hotel id
    lateinit var hotelId: TextView
    lateinit var hotelName: TextView
    lateinit var hotelLocation: TextView
    lateinit var hotelBooking: TextView
    lateinit var hotelPrice: TextView


    //restaurant id
    lateinit var resId: TextView
    lateinit var resName: TextView
    lateinit var resLocation: TextView
    lateinit var resBooking: TextView
    lateinit var resPrice: TextView

    //flight id
    //restaurant id
    lateinit var flightId: TextView
    lateinit var flightName: TextView
    lateinit var flightLocation: TextView
    lateinit var flightBooking: TextView
    lateinit var flightPrice: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        btnRes = findViewById(R.id.btnRes)
        checkOne = findViewById(R.id.checkOne)
        checkTwo = findViewById(R.id.checkTwo)
        checkThree = findViewById(R.id.checkThree)
        etUID = findViewById(R.id.etUID)
//        checkFour = findViewById(R.id.checkFour)

        //hotel id
        hotelId = findViewById(R.id.hotelId)
        hotelName = findViewById(R.id.hotelName)
        hotelLocation = findViewById(R.id.hotelLocation)
        hotelBooking = findViewById(R.id.hotelBooking)
        hotelPrice = findViewById(R.id.hotelPrice)

        //flight id
        flightId = findViewById(R.id.flightId)
        flightName = findViewById(R.id.flightName)
        flightLocation = findViewById(R.id.flightLocation)
        flightBooking = findViewById(R.id.flightBooking)
        flightPrice = findViewById(R.id.flightPrice)

        //flight id
        resId = findViewById(R.id.resId)
        resName = findViewById(R.id.resName)
        resLocation = findViewById(R.id.resLocation)
        resBooking = findViewById(R.id.resBooking)
        resPrice = findViewById(R.id.resPrice)



        btnRes.setOnClickListener {
            if (checkOne.isChecked) {
                Toast.makeText(this, "1 only", Toast.LENGTH_SHORT).show()

                //make flight null
                flightId.text="----"
                flightName.text = "----"
                flightLocation.text = "----"
                flightBooking.text = "----"
                flightPrice.text = "----"

                //make res null
                resId.text="----"
                resName.text = "----"
                resLocation.text = "----"
                resBooking.text = "----"
                resPrice.text = "----"


                fetchHotelRecord(etUID.text.toString())



            }
            if (checkTwo.isChecked) {
                Toast.makeText(this, "2 only", Toast.LENGTH_SHORT).show()
                resId.text="----"
                resName.text = "----"
                resLocation.text = "----"
                resBooking.text = "----"
                resPrice.text = "----"

                hotelId.text="----"
                hotelName.text = "----"
                hotelLocation.text = "----"
                hotelBooking.text = "----"
                hotelPrice.text = "----"

                fetchFlightRecord(etUID.text.toString())


            }
            if (checkThree.isChecked) {
                Toast.makeText(this, "3 only", Toast.LENGTH_SHORT).show()

                flightId.text="----"
                flightName.text = "----"
                flightLocation.text = "----"
                flightBooking.text = "----"
                flightPrice.text = "----"

                hotelId.text="----"
                hotelName.text = "----"
                hotelLocation.text = "----"
                hotelBooking.text = "----"
                hotelPrice.text = "----"

                fetchResturantRecord(etUID.text.toString())
            }
            if (checkOne.isChecked && checkTwo.isChecked) {
                Toast.makeText(this, "1 and 2 selected", Toast.LENGTH_SHORT).show()
                resId.text="----"
                resName.text = "----"
                resLocation.text = "----"
                resBooking.text = "----"
                resPrice.text = "----"
            }
            if (checkOne.isChecked && checkThree.isChecked) {
                Toast.makeText(this, "1 and 3 selected", Toast.LENGTH_SHORT).show()
                flightId.text="----"
                flightName.text = "----"
                flightLocation.text = "----"
                flightBooking.text = "----"
                flightPrice.text = "----"

            }
            if (checkTwo.isChecked && checkThree.isChecked) {
                Toast.makeText(this, "2 and 3 selected", Toast.LENGTH_SHORT).show()
                hotelId.text="----"
                hotelName.text = "----"
                hotelLocation.text = "----"
                hotelBooking.text = "----"
                hotelPrice.text = "----"
            }

            if ( (checkOne.isChecked) && (checkTwo.isChecked) &&(checkThree.isChecked)) {
                Toast.makeText(this, "All selected", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun fetchHotelRecord(userId: String) {
        val url = Conn.url+"hotelFetch.php?userId=$userId"

        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->

                Log.d("FetchHotelRecords", "Response: $response")
                Log.d("FetchHotelRecords", "Response: $response")
                Log.d("FetchHotelRecords", "Response: $response")
                Log.d("FetchHotelRecords", "Response: $response")
                Log.d("FetchHotelRecords", "Response: $response")
                Log.d("FetchHotelRecords", "Response: $response")
                Log.d("FetchHotelRecords", "Response: $response")
                Log.d("FetchHotelRecords", "Response: $response")
                Log.d("FetchHotelRecords", "Response: $response")
                Log.d("FetchHotelRecords", "Response: $response")
                Log.d("FetchHotelRecords", "Response: $response")
                Log.d("FetchHotelRecords", "Response: $response")
                Log.d("FetchHotelRecords", "Response: $response")
                Log.d("FetchHotelRecords", "Response: $response")
                Log.d("FetchHotelRecords", "Response: $response")
                Log.d("FetchHotelRecords", "Response: $response")
                Log.d("FetchHotelRecords", "Response: $response")
                Log.d("FetchHotelRecords", "Response: $response")
                Log.d("FetchHotelRecords", "Response: $response")
                Log.d("FetchHotelRecords", "Response: $response")
                try {
                    // Assuming the response is an array of hotel records
                    for (i in 0 until response.length()) {
                        val obj = response.getJSONObject(i)

                        val hotel_id = obj.getString("hotel_id")
                        val hotel_name = obj.getString("hotel_name")
                        val hotel_location = obj.getString("hotel_location")
                        val hotel_BookingDate = obj.getString("hotel_booking_date")
                        val hotel_OtherBookingDetails = obj.getString("hotel_other_booking_details")

                        // Set text views with fetched data
                        hotelId.text=hotel_id
                        hotelName.text = hotel_name
                        hotelLocation.text = hotel_location
                        hotelBooking.text = hotel_BookingDate
                        hotelPrice.text = hotel_OtherBookingDetails

                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                    Log.e("FetchHotelRecords", "Error parsing JSON: $e")
                }
            },
            Response.ErrorListener { error ->
                Toast.makeText(this, "Error fetching hotel records: ${error.message}", Toast.LENGTH_SHORT).show()
                Log.e("FetchHotelRecords", "Volley error: $error")
            }
        )

        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(jsonArrayRequest)
    }
    private fun fetchFlightRecord(userId: String) {
        val url = Conn.url+"flightFetch.php?userId=$userId"

        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->

                Log.d("FetchHotelRecords", "Response: $response")
                Log.d("FetchHotelRecords", "Response: $response")

                try {
                    // Assuming the response is an array of hotel records
                    for (i in 0 until response.length()) {
                        val obj = response.getJSONObject(i)

                        val flight_id = obj.getString("flight_id")
                        val flight_name = obj.getString("Flight_name")
                        val flight_location = obj.getString("Flight_location")
                        val flight_BookingDate = obj.getString("Flight_booking_date")
                        val flight_OtherBookingDetails = obj.getString("Flight_other_booking_details")

                        // Set text views with fetched data
                        flightId.text=flight_id
                        flightName.text = flight_name
                        flightLocation.text = flight_location
                        flightBooking.text = flight_BookingDate
                        flightPrice.text = flight_OtherBookingDetails

                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                    Log.e("FetchHotelRecords", "Error parsing JSON: $e")
                }
            },
            Response.ErrorListener { error ->
                Toast.makeText(this, "Error fetching hotel records: ${error.message}", Toast.LENGTH_SHORT).show()
                Log.e("FetchHotelRecords", "Volley error: $error")
            }
        )

        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(jsonArrayRequest)
    }

    private fun fetchResturantRecord(userId: String) {
        val url = Conn.url+"resFetch.php?userId=$userId"

        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->

                Log.d("FetchHotelRecords", "Response: $response")
                Log.d("FetchHotelRecords", "Response: $response")

                try {
                    // Assuming the response is an array of hotel records
                    for (i in 0 until response.length()) {
                        val obj = response.getJSONObject(i)

                        val res_id = obj.getString("restaurant_id")
                        val res_name = obj.getString("restaurant_name")
                        val res_location = obj.getString("restaurant_location")
                        val res_BookingDate = obj.getString("restaurant_booking_date")
                        val res_OtherBookingDetails = obj.getString("restaurant_other_booking_details")

                        // Set text views with fetched data
                        resId.text=res_id
                        resName.text = res_name
                        resLocation.text = res_location
                        resBooking.text = res_BookingDate
                        resPrice.text = res_OtherBookingDetails

                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                    Log.e("FetchHotelRecords", "Error parsing JSON: $e")
                }
            },
            Response.ErrorListener { error ->
                Toast.makeText(this, "Error fetching hotel records: ${error.message}", Toast.LENGTH_SHORT).show()
                Log.e("FetchHotelRecords", "Volley error: $error")
            }
        )

        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(jsonArrayRequest)
    }
}