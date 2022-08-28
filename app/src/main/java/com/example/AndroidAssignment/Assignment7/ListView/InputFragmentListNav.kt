package com.example.AndroidAssignment.Assignment7.ListView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.AndroidAssignment.Assignment7.InforFragmentArgs
import com.example.AndroidAssignment.Assignment7.InforFragmentDirections
import com.example.kotlinassignment.R

class InputFragmentNav : Fragment() {

    private var edtnameshow : EditText? = null
    private var edtcostshow : EditText? = null
    private var edtinforshow : EditText? = null
    private var edtcodeshow : EditText? = null
    private var btnadd : Button? = null

    private var costde: Float? = null
    private var namede :String? = null
    private var inforde:String? = null
    private var codede: Int? = null

    val args: InputFragmentNavArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        costde = args.costnav
        codede = args.codenav
        namede = args.namenav
        inforde = args.infornav

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_input_nav, container, false)
        edtnameshow = view.findViewById(R.id.edtNamelist)
        edtcodeshow = view.findViewById(R.id.edtCodelist)
        edtinforshow = view.findViewById(R.id.edtInformationlist)
        edtcostshow = view.findViewById(R.id.edtCostlist)
        btnadd = view.findViewById(R.id.btnaddnewlist)

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (codede != 0 && costde != 0F) {
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

            val action = InputFragmentNavDirections.actionInforToListView(names, codes, costs, infors)
            findNavController().navigate(action)
        }
    }
}