package com.example.AndroidAssignment.Assignment5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.AndroidAssignment.Assignment4.Bai2.ListView.Food
import com.example.kotlinassignment.R

class PutInfoFragment(private var sendPtoR: SendRcvToDetail?) : Fragment() {

    private var edtnameshow : EditText? = null
    private var edtcostshow : EditText? = null
    private var edtinforshow : EditText? = null
    private var edtcodeshow : EditText? = null
    private var btnadd : Button? = null

    private var costde: Float? = null
    private var namede :String? = null
    private var inforde:String? = null

    private var codede: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            costde = it.getFloat("cost",0F)
            namede  = it.getString("name")
            inforde= it.getString("info")
            codede = it.getInt("code",0)
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_put_info, container, false)
        edtnameshow = view.findViewById<EditText>(R.id.edtNamefrag)
        edtcodeshow = view.findViewById<EditText>(R.id.edtCodefrag)
        edtinforshow = view.findViewById<EditText>(R.id.edtInformationfrag)
        edtcostshow = view.findViewById<EditText>(R.id.edtCostfrag)

        btnadd = view.findViewById<Button>(R.id.btnaddnewfrag)
        btnadd?.setOnClickListener {

            val coded = edtcodeshow!!.text.toString().toInt()
            val costd = edtcostshow!!.text.toString().toFloat()
            val named = edtnameshow!!.text.toString()
            val inford = edtinforshow!!.text.toString()

            sendPtoR?.sendPutToRcv(coded,costd,named,inford)

        }
        edtcodeshow!!.setText(codede.toString())
        edtnameshow!!.setText(namede)
        edtcostshow!!.setText(costde.toString())
        edtinforshow!!.setText(inforde)
        return view
    }

}