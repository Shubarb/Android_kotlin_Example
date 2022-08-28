package com.example.AndroidAssignment.Assignment4.Bai2.ListView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.AndroidAssignment.Assignment4.Bai1.ActivityA
import com.example.kotlinassignment.R

class FoodDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)

        var imgfoodshow = findViewById<ImageView>(R.id.imgFoodShow)
        val txtnameshow = findViewById<TextView>(R.id.txtNameFoodShow)
        val txtcostshow = findViewById<TextView>(R.id.txtCostFoodShow)
        val txtinforshow = findViewById<TextView>(R.id.txtInforFoodShow)

        val imgshow = intent.getIntExtra("image",0)
        val nameshow = intent.getStringExtra("name")
        val costshow = intent.getFloatExtra("cost",0F)
        val inforshow = intent.getStringExtra("information")
        val codeshow = intent.getIntExtra("code",0)

        imgfoodshow.setImageResource(imgshow)
        txtnameshow.setText("Name: "+nameshow)
        txtcostshow.setText("Cost: " + costshow)
        txtinforshow.setText("Infor: "+inforshow)

        var btnAccept = findViewById<Button>(R.id.btnUpdateFood)
        btnAccept.setOnClickListener {
            val intent = Intent (this, ListView::class.java)
            intent.putExtra("name2",nameshow)
            intent.putExtra("cost2",costshow)
            intent.putExtra("image2",imgshow)
            intent.putExtra("information2",inforshow)
            intent.putExtra("code2",codeshow)
            startActivity(intent)
        }

    }
}