package com.example.xmlformat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(private var rv: List<dat.Student>): RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return RVAdapter.ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rvlist,parent,false )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val rvv = rv[position]

        holder.itemView.apply {
            findViewById<TextView>(R.id.tvid).text = "id: ${rvv.id}"
            findViewById<TextView>(R.id.tvName).text = rvv.name
            findViewById<TextView>(R.id.tvmark).text = "marks: ${rvv.marks}"
        }
    }

    override fun getItemCount() = rv.size

}