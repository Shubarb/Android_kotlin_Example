package com.example.AndroidAssignment.Assignment4.Bai2.RecycleView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.AndroidAssignment.Assignment4.Bai2.ListView.Food
import com.example.AndroidAssignment.Assignment4.Bai2.ListView.ListView
import com.example.kotlinassignment.R

class FoodDetailsRecycleView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details_recycle_view)

        var imgfoodshow2 = findViewById<ImageView>(R.id.imgFoodShow2)
        val txtnameshow2 = findViewById<TextView>(R.id.txtNameFoodShow2)
        val txtcostshow2 = findViewById<TextView>(R.id.txtCostFoodShow2)
        val txtinforshow2 = findViewById<TextView>(R.id.txtInforFoodShow2)

        val food = intent.getParcelableExtra<Food>("food")
        if(food!=null) {
            imgfoodshow2.setImageResource(food.imgId)
            txtnameshow2.text = "Name: " + food.name
            txtcostshow2.text = "Cost: " + food.cost
            txtinforshow2.text = "Infor: " + food.discription
        }
        var btnAccept = findViewById<Button>(R.id.btnUpdateFood2)
        btnAccept.setOnClickListener {
            val intent = Intent (this, ListView::class.java)
            if(food!=null) {
                intent.putExtra("name3", food.name)
                intent.putExtra("cost3", food.cost)
                intent.putExtra("image3", food.imgId)
                intent.putExtra("information3", food.discription)
                intent.putExtra("code3", food.code)
            }
            startActivity(intent)
        }
    }
}