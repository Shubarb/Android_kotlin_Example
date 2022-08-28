package com.example.AndroidAssignment.Assignment7.ListView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.AndroidAssignment.Assignment4.Bai2.ListView.Food
import com.example.AndroidAssignment.Assignment4.Bai2.ListView.FoodAdapter
import com.example.AndroidAssignment.Assignment7.DetailFragmentDirections
import com.example.AndroidAssignment.Assignment7.Foods
import com.example.AndroidAssignment.Assignment7.RcvFragmentArgs
import com.example.AndroidAssignment.Assignment7.RcvFragmentDirections
import com.example.kotlinassignment.R

class ListViewFragmentNav : Fragment() {


    val listfood : ArrayList<Food> = ArrayList()
    val foodListViewAdapter = FoodAdapter(listfood)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_view_nav, container, false)

        var listViewFood = view.findViewById<ListView>(R.id.listfoodnav)

        listfood.add(Food(R.drawable.girl1,"Scream",25,"Cold",250.00F))
        listfood.add(Food(R.drawable.girl2,"Orange",55,"Chua ngot",23.06F))
        listfood.add(Food(R.drawable.girl3,"Humburger",36,"Da dang vi",15.5F))
        listfood.add(Food(R.drawable.girl4,"FriedRice",85,"Thom ngon tung hat",35.05F))
        listfood.add(Food(R.drawable.girl5,"Potato",111,"Tuoi ngon",38.05F))
        listfood.add(Food(R.drawable.girl6,"Pizza",69,"Day nhieu topping",50.00F))
        listfood.add(Food(R.drawable.girl7,"Mango",99,"Ngot thom",25.00F))

//        val foodListViewAdapter = FoodAdapter(listfood)
        listViewFood?.adapter = foodListViewAdapter

        listViewFood?.setOnItemClickListener { parent, view, position, id ->
            val food = foodListViewAdapter!!.getItem(position) as Food
            val action  = ListViewFragmentNavDirections.actionListViewToDetail(food.name,food.code,food.cost,food.discription,food.imgId )
            findNavController().navigate(action)
        }
        return view
    }

    val args: ListViewFragmentNavArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var count = 0
        for(i in 0 until listfood.size) {
            if (args.codenavlist == listfood[i].code) {
                listfood.add(i,
                    Food(
                        R.drawable.girl8,
                        args.namenavlist,
                        args.codenavlist.toString().toInt(),
                        args.infornavlist,
                        args.costnavlist.toString().toFloat())
                )
                listfood.removeAt(i+1)
                foodListViewAdapter.notifyDataSetChanged()
                break
            }
            else {
                count++

            }
        }
        if(count == listfood.size){
            listfood.add(
                0,
                Food(
                    R.drawable.girl8,
                    args.namenavlist,
                    args.codenavlist.toString().toInt(),
                    args.infornavlist,
                    args.costnavlist.toString().toFloat()
                )
            )
            foodListViewAdapter.notifyDataSetChanged()
            Toast.makeText(activity," Add đấy", Toast.LENGTH_SHORT).show()
        }
    }

}