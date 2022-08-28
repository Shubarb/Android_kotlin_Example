package com.example.AndroidAssignment.Assignment4.Bai1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.AndroidAssignment.Assignment2_3.Bai1.Bai1ActivityB
import com.example.kotlinassignment.R

class ActivityA : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.relativelayout)

        val edt1 = findViewById<EditText>(R.id.edt1)
        val edt2 = findViewById<EditText>(R.id.edt2)
        val edt3 = findViewById<EditText>(R.id.edt3)

        var genders = findViewById<TextView>(R.id.gender)

        val dropdown = findViewById<Spinner>(R.id.dropdown)
        val gender = arrayOf("Nam", "Nữ")


        dropdown.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,gender)
        dropdown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                genders.text = gender.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                genders.text = "Select gender"
            }

        }
        val btnConfirm = findViewById<Button>(R.id.btnConfirm)
        btnConfirm.setOnClickListener {
            val intent = Intent (this, ActivityB::class.java)
            var edt1Text = edt1.text.toString()
            var edt2Text = edt2.text.toString()
            var edt3Text = edt3.text.toString()

            intent.putExtra("account",edt1Text)
            intent.putExtra("name",edt2Text)
            intent.putExtra("age",edt3Text)
            intent.putExtra("gender",genders.text)

            startActivityForResult(intent,1)
        }


    }
}