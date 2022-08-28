package com.example.AndroidAssignment.Assignment5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.AndroidAssignment.Assignment4.Bai2.ListView.Food
import com.example.kotlinassignment.R

class RcvFoodFragment(private var sendRtoD: SendRcvToDetail?) : Fragment() {

    val listfood : ArrayList<Food> = ArrayList()
    val adapterRecycle = FoodAdapterRcv(listfood)
    val linearLayoutManager = LinearLayoutManager(context)
    var recycleViewFood : RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_rcv_food, container, false)

        recycleViewFood = view.findViewById<RecyclerView>(R.id.fragmentRcv)
        recycleViewFood?.adapter = adapterRecycle
        recycleViewFood?.layoutManager = linearLayoutManager

        listfood.add(Food(R.drawable.girl1,"Scream",1,"Cold",250.00F))
        listfood.add(Food(R.drawable.girl2,"Orange",2,"Chua ngot",23.06F))
        listfood.add(Food(R.drawable.girl3,"Humburger",3,"Da dang vi",15.5F))
        listfood.add(Food(R.drawable.girl4,"FriedRice",4,"Thom ngon tung hat",35.05F))
        listfood.add(Food(R.drawable.girl5,"Potato",5,"Tuoi ngon",38.05F))
        listfood.add(Food(R.drawable.girl6,"Pizza",6,"Day nhieu topping",50.00F))
        listfood.add(Food(R.drawable.girl7,"Mango",7,"Ngot thom",25.00F))

        adapterRecycle.onItemClick = {
            var rcvFood = it
            sendRtoD?.senRcvToDetail(rcvFood)
        }
        return view


    }

    fun setDataPut(codede: Int?, costde: Float?,namede:String?,inforde: String?){
        var count: Int = 0
        for(i in 0 until listfood.size) {
            if (codede == listfood[i].code) {
                listfood.add(i,
                    Food(
                        R.drawable.girl8,
                        namede.toString(),
                        codede.toString().toInt(),
                        inforde.toString(),
                        costde.toString().toFloat()))
                listfood.removeAt(i+1)
                adapterRecycle.notifyDataSetChanged()
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
                    namede.toString(),
                    codede.toString().toInt(),
                    inforde.toString(),
                    costde.toString().toFloat()
                )
            )
            adapterRecycle.notifyDataSetChanged()
            Toast.makeText(activity," Add đấy",Toast.LENGTH_SHORT).show()
        }
    }
}
