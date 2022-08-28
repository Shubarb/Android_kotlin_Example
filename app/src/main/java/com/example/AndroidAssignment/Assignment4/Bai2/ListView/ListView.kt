package com.example.AndroidAssignment.Assignment4.Bai2.ListView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.widget.ListView
import com.example.AndroidAssignment.Assignment4.Bai1.ActivityB
import com.example.kotlinassignment.R

class ListView : AppCompatActivity() {

//    private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_list_view)

        var listViewFood = findViewById<ListView>(R.id.listfood)
        val listfood : ArrayList<Food> = ArrayList()

        val edtName = findViewById<EditText>(R.id.edtName)
        val edtCode = findViewById<EditText>(R.id.edtCode)
        val edtInfor = findViewById<EditText>(R.id.edtInformation)
        val edtCost = findViewById<EditText>(R.id.edtCost)
//        val imgview = findViewById<ImageView>(R.id.)

        listfood.add(Food(R.drawable.girl1,"Scream",25,"Cold",250.00F))
        listfood.add(Food(R.drawable.girl2,"Orange",55,"Chua ngot",23.06F))
        listfood.add(Food(R.drawable.girl3,"Humburger",36,"Da dang vi",15.5F))
        listfood.add(Food(R.drawable.girl4,"FriedRice",85,"Thom ngon tung hat",35.05F))
        listfood.add(Food(R.drawable.girl5,"Potato",111,"Tuoi ngon",38.05F))
        listfood.add(Food(R.drawable.girl6,"Pizza",69,"Day nhieu topping",50.00F))
        listfood.add(Food(R.drawable.girl7,"Mango",99,"Ngot thom",25.00F))

        val foodListViewAdapter = FoodAdapter(listfood)
        listViewFood?.adapter = foodListViewAdapter

        listViewFood?.setOnItemClickListener { parent,view,position,id ->
            val food = foodListViewAdapter!!.getItem(position) as Food
            val intent = Intent (this, FoodDetails::class.java)
            intent.putExtra("name",food.name)
            intent.putExtra("cost",food.cost)
            intent.putExtra("image",food.imgId)
            intent.putExtra("information",food.discription)
            intent.putExtra("code",food.code)
            startActivityForResult(intent,1)
        }

        val btnadd = findViewById<Button>(R.id.btnAddnew)
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
            foodListViewAdapter.notifyDataSetChanged()

        }

        val btnAccept = findViewById<Button>(R.id.btnAccept)
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
                    foodListViewAdapter.notifyDataSetChanged()
                }
            }
        }
        val nameshow = intent.getStringExtra("name2")
        val costshow = intent.getFloatExtra("cost2",0F)
        val inforshow = intent.getStringExtra("information2")
        val codeshow = intent.getIntExtra("code2",0)

        edtCode.setText(codeshow.toString())
        edtCost.setText(costshow.toString())
        edtInfor.setText(inforshow)
        edtName.setText(nameshow)
    }
}