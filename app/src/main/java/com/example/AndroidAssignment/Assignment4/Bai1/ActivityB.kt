package com.example.AndroidAssignment.Assignment4.Bai1

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinassignment.R

class ActivityB : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.relativelayoutb)

        var txtwelcome = findViewById<TextView>(R.id.txtWelcome)
        var txtaccout = findViewById<TextView>(R.id.txtAccout)
        var txtage = findViewById<TextView>(R.id.txtAge)

        val welcome = intent.getStringExtra("name")
        val account = intent.getStringExtra("account")
        val age = intent.getStringExtra("age")
        val gender = intent.getStringExtra("gender")


        var txtgender = findViewById<TextView>(R.id.txtGender)

        txtwelcome.setText("Chào mừng\n" + welcome)
        txtaccout.setText("Tài khoản: " + account)
        txtage.setText("Tuổi: "+age)
        txtgender.setText("Giới tính: "+ gender)

        val btnOK = findViewById<Button>(R.id.btnOk)
        btnOK.setOnClickListener {
            val intent = Intent (this, ActivityA::class.java)
            startActivity(intent)
        }

        val btnCancel = findViewById<Button>(R.id.btnCancel)
        btnCancel.setOnClickListener {
            val intent = Intent (this, ActivityA::class.java)
            setResult(RESULT_OK,intent)
            finish()
        }

    }
}