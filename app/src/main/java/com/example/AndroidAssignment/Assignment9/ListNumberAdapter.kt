package com.example.AndroidAssignment.Assignment9

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.AndroidAssignment.Assignment8.ListMusicAdapter
import com.example.AndroidAssignment.Assignment8.Music
import com.example.kotlinassignment.R

class ListNumberAdapter (private var mlistnumber: List<Contact>,
                         private var ctx: Context
                         ): RecyclerView.Adapter<ListNumberAdapter.NumberViewHolder>()
{
    var onItemClick: ((Contact) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        ctx = parent.context
        val inflater = LayoutInflater.from(ctx)
        val musicView: View = inflater.inflate(R.layout.number, parent, false)
        return NumberViewHolder(musicView)
    }

    override fun onBindViewHolder(viewHolder: NumberViewHolder, position: Int) {
        val number: Contact = mlistnumber[position]
        viewHolder.name?.text = String.format(number.name)
        viewHolder.number?.text = String.format(number.number)
        viewHolder.itemView.setOnClickListener {
            onItemClick?.invoke(number)
        }

}

    override fun getItemCount(): Int {
        return mlistnumber.size
    }

    inner class NumberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name : TextView? = null
        var number: TextView? = null

        init {
            name = itemView.findViewById(R.id.txtNamePhone) as TextView
            number = itemView.findViewById(R.id.txtNumberPhone) as TextView

        }
    }
}