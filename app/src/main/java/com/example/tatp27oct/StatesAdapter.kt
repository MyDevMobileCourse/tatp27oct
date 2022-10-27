package com.example.tatp27oct

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

internal class StatesAdapter (private var data :List<Pair<String,Int>>): RecyclerView.Adapter<StatesAdapter.MyViewHolder>() {
    internal inner class MyViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        var stateName : TextView = view.findViewById(R.id.stateName)
        var stateImage : ImageView = view.findViewById(R.id.stateImage)
//        var item : TextView = view.findViewById(R.id.textView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.line,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = data[position]
        holder.stateName.text = item.first
        holder.stateImage.setImageResource(item.second)

    }

    override fun getItemCount(): Int {
        return data.size
    }
}