package com.example.AndroidAssignment.Assignment7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.AndroidAssignment.Assignment4.Bai2.ListView.Food
import com.example.AndroidAssignment.Assignment5.FoodAdapterRcv
import com.example.kotlinassignment.R

class RcvFragment : Fragment() {
    val listfood : ArrayList<Foods> = ArrayList()
    val adapterRecycle = rcvAdapter(listfood)
    val linearLayoutManager = LinearLayoutManager(context)
    var recycleViewFood : RecyclerView? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_rcv, container, false)

        recycleViewFood = view.findViewById(R.id.fragmentRcv)
        recycleViewFood?.adapter = adapterRecycle
        recycleViewFood?.layoutManager = linearLayoutManager

        listfood.add(Foods(R.drawable.girl1,"Scream",1,"Cold",250.00F))
        listfood.add(Foods(R.drawable.girl2,"Orange",2,"Chua ngot",23.06F))
        listfood.add(Foods(R.drawable.girl3,"Humburger",3,"Da dang vi",15.5F))
        listfood.add(Foods(R.drawable.girl4,"FriedRice",4,"Thom ngon tung hat",35.05F))
        listfood.add(Foods(R.drawable.girl5,"Potato",5,"Tuoi ngon",38.05F))
        listfood.add(Foods(R.drawable.girl6,"Pizza",6,"Day nhieu topping",50.00F))
        listfood.add(Foods(R.drawable.girl7,"Mango",7,"Ngot thom",25.00F))

        adapterRecycle.onItemClick = {
            var rcvFood = it
            val action  = RcvFragmentDirections.actionRcvToDetail(rcvFood)
            findNavController().navigate(action)
        }
        return view
    }

    val args: RcvFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var count = 0
        for(i in 0 until listfood.size) {
            if (args.codercv == listfood[i].code) {
                listfood.add(i,
                    Foods(
                        R.drawable.girl8,
                        args.namercv,
                        args.codercv.toString().toInt(),
                        args.informationrcv,
                        args.costrcv.toString().toFloat()))
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
                Foods(
                    R.drawable.girl8,
                    args.namercv,
                    args.codercv.toString().toInt(),
                    args.informationrcv,
                    args.costrcv.toString().toFloat()
                )
            )
            adapterRecycle.notifyDataSetChanged()
            Toast.makeText(activity," Add đấy", Toast.LENGTH_SHORT).show()
        }
    }
}