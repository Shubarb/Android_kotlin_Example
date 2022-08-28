package com.example.AndroidAssignment.Assignment2_3.Bai1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.kotlinassignment.R

class Bai1ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bai1_activity_b)
        var b = intent.getStringExtra("list")
//        var txt = findViewById<TextView>(R.id.textView2)
//        txt.setText(b.toString())
        Log.d("bbb",b.toString())
    }
}