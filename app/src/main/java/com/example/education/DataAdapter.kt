package com.example.education

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(items: MutableList<Item>, listener: OnItemClickListener) : RecyclerView.Adapter<DataAdapter.ViewHolder>(){
    private val items: MutableList<Item>
    private val listener: OnItemClickListener

    init {
        this.items = ArrayList(items)
        this.listener = listener
    }

    interface OnItemClickListener {
        fun onItemClick(item: Item, position: Int)
    }

    class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameView: TextView = itemView.findViewById(R.id.name)
        val imageView: ImageView = itemView.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item , parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: Item  = items[position]
        holder.nameView.text = item.name
        holder.imageView.setImageResource(item.image)
        holder.itemView.setOnClickListener { listener.onItemClick(item, position) }
    }

    override fun getItemCount() = items.size
}