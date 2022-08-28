package com.example.AndroidAssignment.Assignment7

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinassignment.R

class rcvAdapter (
    private val mlistFood: ArrayList<Foods>
//    private var foodListListener: Listener
    ): RecyclerView.Adapter<rcvAdapter.FoodViewHolder>() {
    var onItemClick: ((Foods) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rcvAdapter.FoodViewHolder {
        val context: Context = parent.context
        val inflater = LayoutInflater.from(context)
        val foodView: View = inflater.inflate(R.layout.itemlinear,parent,false)
        return FoodViewHolder(foodView)
    }

    override fun onBindViewHolder(viewHolder: rcvAdapter.FoodViewHolder, position: Int) {
        val food: Foods = mlistFood[position]
        viewHolder.tvId!!.text = String.format("Mã: "+food.code.toString())
        viewHolder.tvInfo!!.text = String.format("Mô tả: "+food.discription)
        viewHolder.tvName!!.text = String.format("Tên: "+ food.name)
        viewHolder.tvPrice!!.text = String.format("Giá: "+food.cost.toString())
        viewHolder.imgFood!!.setImageResource(food.imgId)
        viewHolder.itemView.setOnClickListener{
            onItemClick?.invoke(food)
//            foodListListener.onClickListItem(food,position)
        }
    }

    override fun getItemCount(): Int {
        return  mlistFood.size
    }


    inner class FoodViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var tvId: TextView? = null
        var tvName: TextView? = null
        var tvPrice: TextView?= null
        var tvInfo: TextView? =null
        var imgFood: ImageView? = null


        init{
            tvId = itemView.findViewById(R.id.txtCode) as TextView
            tvName = itemView.findViewById(R.id.txtNameFood) as TextView
            tvPrice = itemView.findViewById(R.id.txtCostFood) as TextView
            tvInfo = itemView.findViewById(R.id.txtInforFood) as TextView
            imgFood = itemView.findViewById(R.id.imgFood) as ImageView


        }
    }

}

