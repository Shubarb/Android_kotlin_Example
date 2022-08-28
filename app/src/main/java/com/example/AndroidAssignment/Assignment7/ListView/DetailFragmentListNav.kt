package com.example.AndroidAssignment.Assignment7.ListView

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
import com.example.AndroidAssignment.Assignment7.DetailFragmentArgs
import com.example.AndroidAssignment.Assignment7.DetailFragmentDirections
import com.example.kotlinassignment.R

class DetailFragmentListNav : Fragment() {

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

    val args: DetailFragmentListNavArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cost = args.costnavde
        code = args.codenavde
        name = args.namenavde
        img = args.imgnavde
        infor = args.infornavde
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_detail_list_nav, container, false)
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
            val action  = DetailFragmentListNavDirections.actionDeToInfo()
            action.namenav = args.namenavde
            action.codenav = args.codenavde
            action.costnav = args.costnavde
            action.infornav = args.infornavde
            findNavController().navigate(action)
        }
    }

}