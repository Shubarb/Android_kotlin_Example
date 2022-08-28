package com.example.AndroidAssignment.Assignment7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kotlinassignment.R

class DetailFragment : Fragment() {

    var imgfoodshow2 : ImageView? = null
    var txtnameshow2 : TextView? = null
    var txtcostshow2 : TextView? = null
    var txtinforshow2 : TextView? = null

    private var cost: Float? = null
    private var name :String? = null
    private var infor:String? = null
    private var img: Int? = null
    private var code: Int? = null

    private var btnUpdate : Button? = null

    val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cost = args.food.cost
        code = args.food.code
        name = args.food.name
        img = args.food.imgId
        infor = args.food.discription
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_detail, container, false)
        imgfoodshow2 = view.findViewById(R.id.imgFoodDetail)
        txtnameshow2 = view.findViewById(R.id.txtNameFoodDetail)
        txtcostshow2 = view.findViewById(R.id.txtCostFoodDetail)
        txtinforshow2 = view.findViewById(R.id.txtInforFoodDetail)


        imgfoodshow2!!.setImageResource(img!!.toString().toInt())
        txtnameshow2!!.setText("Name: " + name)
        txtcostshow2!!.setText("Cost: " + cost.toString())
        txtinforshow2!!.setText("Infor: " + infor)

        btnUpdate = view.findViewById(R.id.btnUpdateDetail)

        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnUpdate?.setOnClickListener {
            val action  = DetailFragmentDirections.actionDetailToInfor()
            action.namei = args.food.name
            action.codei = args.food.code
            action.costi = args.food.cost
            action.informationi = args.food.discription
            findNavController().navigate(action)
        }
    }
}