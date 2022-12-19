package com.example.internassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(): RecyclerView.Adapter<NewsViewHolder>() {

    private val items: ArrayList<definitions> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        val viewHolder = NewsViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = items[position]
        holder.definition.text = currentItem.definition
        holder.type.text = currentItem.type
    }

    fun updateResponse(updatedNews: List<definitions>) {
        items.clear()
        items.addAll(updatedNews)

        notifyDataSetChanged()
    }
}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val definition: TextView = itemView.findViewById(R.id.tvDefinition)
    val type: TextView = itemView.findViewById(R.id.tvType)
}
