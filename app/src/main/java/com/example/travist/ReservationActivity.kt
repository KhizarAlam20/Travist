package com.example.travist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class ReservationActivity : AppCompatActivity() {
    lateinit var etUID: EditText
    lateinit var checkOne: CheckBox
    lateinit var checkTwo: CheckBox
    lateinit var checkThree: CheckBox
//    lateinit var checkFour: CheckBox
    lateinit var btnRes: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        btnRes = findViewById(R.id.btnRes)
        checkOne = findViewById(R.id.checkOne)
        checkTwo = findViewById(R.id.checkTwo)
        checkThree = findViewById(R.id.checkThree)
//        checkFour = findViewById(R.id.checkFour)

        btnRes.setOnClickListener {
            if (checkOne.isChecked) {
                Toast.makeText(this, "1 only", Toast.LENGTH_SHORT).show()
            }
            if (checkTwo.isChecked) {
                Toast.makeText(this, "2 only", Toast.LENGTH_SHORT).show()
            }
            if (checkThree.isChecked) {
                Toast.makeText(this, "3 only", Toast.LENGTH_SHORT).show()
            }
            if (checkOne.isChecked && checkTwo.isChecked) {
                Toast.makeText(this, "1 and 2 selected", Toast.LENGTH_SHORT).show()
            }
            if (checkOne.isChecked && checkThree.isChecked) {
                Toast.makeText(this, "1 and 3 selected", Toast.LENGTH_SHORT).show()
            }
            if (checkTwo.isChecked && checkThree.isChecked) {
                Toast.makeText(this, "2 and 3 selected", Toast.LENGTH_SHORT).show()
            }

            if ( (checkOne.isChecked) && (checkTwo.isChecked) &&(checkThree.isChecked)) {
                Toast.makeText(this, "All selected", Toast.LENGTH_SHORT).show()
            }
        }

    }
}