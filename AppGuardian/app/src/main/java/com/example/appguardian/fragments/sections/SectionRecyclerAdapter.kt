package com.example.appguardian.fragments.sections

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appguardian.R
import com.example.appguardian.models.pojo.Section
import com.example.appguardian.models.room.entity.SectionEntity

class SectionRecyclerAdapter(
    var onClickRecyclerItem: OnClickRecyclerItem,
    var onSectionFavoriteListener: OnSectionFavoriteListener
) : RecyclerView.Adapter<SectionRecyclerAdapter.SectionsViewHolder>() {
    private var items = mutableListOf<Section.Response.Result>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.section_recycler_item,
            parent,
            false
        )
        return SectionsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SectionsViewHolder, position: Int) {
        holder.bind(items[position], onClickRecyclerItem, onSectionFavoriteListener)

    }

    override fun getItemCount(): Int = items.size

    inner class SectionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var sectionName: TextView
        lateinit var favoriteCB: CheckBox
        fun bind(response: Section.Response.Result, onClickRecyclerItem: OnClickRecyclerItem, onSectionFavoriteListener: OnSectionFavoriteListener) {
            sectionName = itemView.findViewById(R.id.sectionsTitle)
            favoriteCB = itemView.findViewById(R.id.favCheckBox)
            sectionName.text = response.webTitle

            if (response.favorite) {
                favoriteCB.isChecked = false
            } else
                if (!response.favorite) {
                    favoriteCB.isChecked = true
                }
            favoriteCB.isChecked = response.favorite
            itemView.setOnClickListener {
                onClickRecyclerItem.onItemClick(response.id)
            }
            favoriteCB.setOnClickListener {
                it as CheckBox
                if (it.isChecked){
                    response.favorite = it.isChecked
                    it.isChecked = true
                }
                else{
                    response.favorite = it.isChecked
                    it.isChecked = false
                }
                onSectionFavoriteListener.onclickFavSec(response,adapterPosition,it.isChecked)
            }
        }
    }

    fun favChanged(list:List<SectionEntity>){
        items.forEach { result ->
            result.favorite=false
            list.forEach {
                if (result.id==it.id)
                    result.favorite=true

            }
        }
        notifyDataSetChanged()
    }
    fun updateDate(sectionsList: List<Section.Response.Result>?) {
        sectionsList?.let {
            items.clear()
            items.addAll(sectionsList)
            notifyDataSetChanged()
        }

    }
}

interface OnClickRecyclerItem {
    fun onItemClick(id: Any?)
}

interface OnSectionFavoriteListener {
    fun onclickFavSec(item: Section.Response.Result, position: Int, isChecked: Boolean)
}