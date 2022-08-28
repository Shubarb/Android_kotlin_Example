package com.example.AndroidAssignment.QuangTV19_BAD_FinalTest

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.AndroidAssignment.Assignment6.Bai1.SendDialog
import com.example.kotlinassignment.R

class DialogFragmentFinal : DialogFragment() {

    private var i = 0
    private var txtnumber : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
            i = it.getInt("img",0)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_dialog2, container, false)
        txtnumber = view.findViewById(R.id.txtnumber)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtnumber?.setText("Kết quả: $i")
    }

}