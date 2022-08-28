package com.example.AndroidAssignment.Assignment2_3.Bai3

import android.content.BroadcastReceiver
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.kotlinassignment.R

class Assignment2_3_Bai3b : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment23_bai3b)


        val share = findViewById<Button>(R.id.btnshare2)
        share.setOnClickListener(){
            val intent = Intent()
            intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
            intent.action = "com.example.fresher2022_kotlin_quangtv19b.AndroidAssignment.Assignment23.Bai3.MyReceiver"
            sendBroadcast(intent)
//            Toast.makeText(this,"test",Toast.LENGTH_SHORT).show()
        }

    }
}