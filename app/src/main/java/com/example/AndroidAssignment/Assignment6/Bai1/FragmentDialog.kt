package com.example.AndroidAssignment.Assignment6.Bai1

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.kotlinassignment.R

class FragmentDialog(private var sendDialog: SendDialog?) : DialogFragment(){
    private var btnYes: Button? = null
    private var btnNo: Button? = null

    ///Using onCreateView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_dialog, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnYes = view.findViewById(R.id.btnyes)
        btnNo = view.findViewById(R.id.btnno)

        btnYes!!.setOnClickListener {
            sendDialog?.sendDialog1("You click yes")
        }
        btnNo!!.setOnClickListener {
            sendDialog?.sendDialog1("You click No")
        }
    }

    ///Using onCreateDialog
//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        return AlertDialog.Builder(activity)
//            .setTitle("Confirm dialog title")
//            .setMessage("Confirm dialog content")
//            .setPositiveButton("Yes",
//                DialogInterface.OnClickListener { _, _ ->
//                    sendDialog?.sendDialog1("You click yes")
//                })
//            .setNegativeButton("No",
//                DialogInterface.OnClickListener { _, _ ->
//                    sendDialog?.sendDialog1("You click No")
//                })
//            .create()
//    }
}