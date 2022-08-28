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
import com.example.AndroidAssignment.Assignment4.Bai2.ListView.Food
import com.example.kotlinassignment.R

class DetailsFragment(private var sendDtoP: SendRcvToDetail?) : Fragment() {

//    private var dataReceive: Food? = null

     var imgfoodshow2 :ImageView? = null
     var txtnameshow2 :TextView? = null
     var txtcostshow2 :TextView? = null
     var txtinforshow2 :TextView? = null

    private var cost: Float? = null
    private var name :String? = null
    private var infor:String? = null
    private var img: Int? = null
    private var code: Int? = null

    private var btnUpdate :Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
            cost = it.getFloat("cost",0F)
            name  = it.getString("name")
            infor= it.getString("info")
            code = it.getInt("code",0)
            img = it.getInt("img",0)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_details, container, false)
        imgfoodshow2 = view.findViewById(R.id.imgFoodDetail)
        txtnameshow2 = view.findViewById(R.id.txtNameFoodDetail)
        txtcostshow2 = view.findViewById(R.id.txtCostFoodDetail)
        txtinforshow2 = view.findViewById(R.id.txtInforFoodDetail)


        imgfoodshow2!!.setImageResource(img!!.toString().toInt())
        txtnameshow2!!.setText("Name: " + name)
        txtcostshow2!!.setText("Cost: " + cost.toString())
        txtinforshow2!!.setText("Infor: " + infor)

        btnUpdate = view.findViewById(R.id.btnUpdateDetail)
        btnUpdate?.setOnClickListener {
            sendDtoP?.senDetailToPut(
                code.toString().toInt(),
                cost.toString().toFloat(),
                name,
                infor
            )
        }


        return  view
    }


}