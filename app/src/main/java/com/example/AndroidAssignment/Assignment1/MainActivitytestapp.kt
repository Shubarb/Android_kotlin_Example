package com.example.AndroidAssignment.Assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.kotlinassignment.R

class MainActivitytestapp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activitytestapp)

        var clicks = findViewById<Button>(R.id.click)
        clicks.setOnClickListener{

        }
    }
}