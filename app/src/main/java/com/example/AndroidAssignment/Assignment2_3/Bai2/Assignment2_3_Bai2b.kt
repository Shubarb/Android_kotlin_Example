package com.example.AndroidAssignment.Assignment2_3.Bai2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.kotlinassignment.R

class Assignment2_3_Bai2b : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment23_bai2b)

        var a = intent.getIntExtra("aaa1",0)
        var b = intent.getIntExtra("aaa2",0)
        var result:Int  = a + b

//        var resultbtn = findViewById<Button>(R.id.btnResult)
//        resultbtn.setOnClickListener{
            val intent: Intent = Intent (this, Assignment2_3_Bai2a::class.java)
            intent.putExtra("bbb",result)
            startActivity(intent)
            finish()
//        }

    }
}