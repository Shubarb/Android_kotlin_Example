package com.example.AndroidAssignment.Assignment2_3.Bai2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.AndroidAssignment.Assignment2_3.Bai1.Bai1ActivityB
import com.example.kotlinassignment.R

class Assignment2_3_Bai2a : AppCompatActivity() {

    var a: Int = 3
    var b: Int = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment23_bai2a)

        var txta = findViewById<TextView>(R.id.a)
        txta.setText(a.toString())
        var txtb = findViewById<TextView>(R.id.b)
        txtb.setText(b.toString())

        var sum = findViewById<Button>(R.id.btnSum)
        sum.setOnClickListener{
            val intent: Intent = Intent (this, Assignment2_3_Bai2b::class.java)
            intent.putExtra("aaa1",a)
            intent.putExtra("aaa2",b)
            startActivityForResult(intent,1)
        }

        var result = intent.getIntExtra("bbb",0)
        Log.d("logcatA",result.toString())
    }
}