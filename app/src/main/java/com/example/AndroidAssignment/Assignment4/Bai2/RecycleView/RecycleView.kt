package com.example.AndroidAssignment.Assignment4.Bai2.RecycleView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.AndroidAssignment.Assignment4.Bai2.ListView.Food
import com.example.AndroidAssignment.Assignment4.Bai2.ListView.FoodDetails
import com.example.kotlinassignment.R

class RecycleView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)

        var recycleViewFood = findViewById<RecyclerView>(R.id.rcvFood)
        val listfood : ArrayList<Food> = ArrayList()

        val edtName = findViewById<EditText>(R.id.edtNamercv)
        val edtCode = findViewById<EditText>(R.id.edtCodercv)
        val edtInfor = findViewById<EditText>(R.id.edtInformationrcv)
        val edtCost = findViewById<EditText>(R.id.edtCostrcv)

        listfood.add(Food(R.drawable.girl1,"Scream",1,"Cold",250.00F))
        listfood.add(Food(R.drawable.girl2,"Orange",2,"Chua ngot",23.06F))
        listfood.add(Food(R.drawable.girl3,"Humburger",3,"Da dang vi",15.5F))
        listfood.add(Food(R.drawable.girl4,"FriedRice",4,"Thom ngon tung hat",35.05F))
        listfood.add(Food(R.drawable.girl5,"Potato",5,"Tuoi ngon",38.05F))
        listfood.add(Food(R.drawable.girl6,"Pizza",6,"Day nhieu topping",50.00F))
        listfood.add(Food(R.drawable.girl7,"Mango",7,"Ngot thom",25.00F))

        val adapterRecycle = FoodAdapterRecycle(listfood)
        val linearLayoutManager = LinearLayoutManager(this)
        recycleViewFood?.adapter = adapterRecycle
        recycleViewFood?.layoutManager = linearLayoutManager

        adapterRecycle.onItemClick = {
            val intent = Intent (this, FoodDetailsRecycleView::class.java)
            intent.putExtra("food",it)
            startActivity(intent)
        }

        val btnadd = findViewById<Button>(R.id.btnaddnewrcv)
        btnadd.setOnClickListener {
            listfood.add(0,
                Food(
                    R.drawable.girl8,
                    edtName.text.toString(),
                    edtCode.text.toString().toInt(),
                    edtInfor.text.toString(),
                    edtCost.text.toString().toFloat()
                )
            )
            adapterRecycle.notifyDataSetChanged()

        }

        val btnAccept = findViewById<Button>(R.id.btnAcceptrcv)
        btnAccept.setOnClickListener {

            for(i in 0 until listfood.size-1){
                if(edtCode.text.toString() == listfood[i].code.toString()){
                    listfood.add(i,
                        Food(
                            R.drawable.girl8,
                            edtName.text.toString(),
                            edtCode.text.toString().toInt(),
                            edtInfor.text.toString(),
                            edtCost.text.toString().toFloat()))
                    listfood.removeAt(i+1)
                    adapterRecycle.notifyDataSetChanged()
                }
            }
        }

        val nameshow = intent.getStringExtra("name3")
        val costshow = intent.getFloatExtra("cost3",0F)
        val inforshow = intent.getStringExtra("information3")
        val codeshow = intent.getIntExtra("code3",0)

        edtCode.setText(codeshow.toString())
        edtCost.setText(costshow.toString())
        edtInfor.setText(inforshow)
        edtName.setText(nameshow)
    }
}