package com.example.AndroidAssignment.Assignment4.Bai2.ListView

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.persistableBundleOf
import com.example.kotlinassignment.R
import java.sql.DriverPropertyInfo

class FoodAdapter (
    private val listFood: ArrayList<Food>): BaseAdapter() {
    override fun getCount(): Int {
        return listFood.size
    }

    override fun getItem(p0: Int): Any {
        return listFood[p0]
    }

    override fun getItemId(p0: Int): Long {
        return listFood[p0].code.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup): View {
        val viewFood: View = p1
            ?:View.inflate(p2.context,R.layout.itemlinear,null)
        val food = getItem(p0) as Food
        (viewFood.findViewById(R.id.imgFood) as ImageView).setImageResource(food.imgId)
        (viewFood.findViewById(R.id.txtNameFood)as TextView).text = String.format("Tên: "+ food.name)
        (viewFood.findViewById(R.id.txtInforFood)as TextView).text = String.format("Mô tả: "+food.discription)
        (viewFood.findViewById(R.id.txtCostFood)as TextView).text = String.format("Giá: "+food.cost.toString())
        (viewFood.findViewById(R.id.txtCode)as TextView).text = String.format("Mã: "+food.code.toString())
        return viewFood
    }


}
