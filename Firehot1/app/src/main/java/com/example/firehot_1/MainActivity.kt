package com.example.firehot_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btclear.setOnClickListener {
            firstn.setText("")
            lastn.setText("")
        }

        btsend.setOnClickListener {
            val first = firstn.text.toString()
            val last = lastn.text.toString()

            val firebase = FirebaseDatabase.getInstance()
            val ref = firebase.getReference("Employee")
            val id: String? = ref.push().key

            val Employee = Employee(id.toString(), first, last)

            ref.child(id.toString()).setValue(Employee).addOnCompleteListener {
                Toast.makeText(applicationContext, "Complete", Toast.LENGTH_LONG).show()
                firstn.setText("")
                lastn.setText("")
            }

        }
    }
}