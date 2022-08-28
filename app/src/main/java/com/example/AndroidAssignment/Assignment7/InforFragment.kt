package com.example.AndroidAssignment.Assignment7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.ActivityNavigator
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinassignment.R

class InforFragment : Fragment() {

    private var edtnameshow : EditText? = null
    private var edtcostshow : EditText? = null
    private var edtinforshow : EditText? = null
    private var edtcodeshow : EditText? = null
    private var btnadd : Button? = null

    private var costde: Float? = null
    private var namede :String? = null
    private var inforde:String? = null
    private var codede: Int? = null

    val args: InforFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        costde = args.costi
        codede = args.codei
        namede = args.namei
        inforde = args.informationi

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_infor, container, false)
        edtnameshow = view.findViewById(R.id.edtNamefrag2)
        edtcodeshow = view.findViewById(R.id.edtCodefrag2)
        edtinforshow = view.findViewById(R.id.edtInformationfrag2)
        edtcostshow = view.findViewById(R.id.edtCostfrag2)
        btnadd = view.findViewById(R.id.btnaddnewfrag)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(codede != 0 && costde != 0F) {
            edtcodeshow!!.setText(codede.toString())
            edtnameshow!!.setText(namede)
            edtcostshow!!.setText(costde.toString())
            edtinforshow!!.setText(inforde)
        }

        btnadd?.setOnClickListener {
//
            val codes = edtcodeshow!!.text.toString().toInt()
            val costs = edtcostshow!!.text.toString().toFloat()
            val names = edtnameshow!!.text.toString()
            val infors = edtinforshow!!.text.toString()

            val action  = InforFragmentDirections.actionInforToRcv(names,codes,costs,infors)
            findNavController().navigate(action)

        }


    }
}

