package com.bichri.yewou.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bichri.yewou.R
import com.bichri.yewou.model.HomeModel

class HomeAdapter(val context: Context,val crowFundings:List<HomeModel>):RecyclerView.Adapter<HomeAdapter.Holder>() {


    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bindView(context: Context,crwd: HomeModel){
            val title = itemView.findViewById<TextView>(R.id.item_title)
            val desc = itemView.findViewById<TextView>(R.id.item_descirption)


            title.text = "contact.title"
            desc.text =" contact.desc"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_home,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindView(context,crowFundings[position])
    }

    override fun getItemCount(): Int {
        return crowFundings.count()
    }
}