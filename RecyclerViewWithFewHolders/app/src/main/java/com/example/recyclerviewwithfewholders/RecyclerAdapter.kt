package com.example.recyclerviewwithfewholders

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithfewholders.models.News

class RecyclerAdapter() : RecyclerView.Adapter<RecyclerAdapter.BaseViewHolder>() {

    private val newsList = arrayListOf<News>()

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = newsList.size

    class StatusViewHolder(itemView: View) : BaseViewHolder(itemView) {
        val statusTitle = itemView.findViewById<TextView>(R.id.statusTitle)
        val statusText = itemView.findViewById<TextView>(R.id.statusText)
        override fun bind() {
        }

    }

    class MediaViewHolder(itemView: View) : BaseViewHolder(itemView) {
        override fun bind() {

        }

    }
}