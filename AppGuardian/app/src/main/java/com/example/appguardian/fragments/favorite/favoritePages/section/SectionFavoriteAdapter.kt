package com.example.appguardian.fragments.favorite.favoritePages.section

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appguardian.R
import com.example.appguardian.fragments.favorite.OnDeleteItemFromFavListener
import com.example.appguardian.fragments.sections.OnClickRecyclerItem
import com.example.appguardian.models.room.entity.SectionEntity


class SectionFavoriteAdapter(var onClickRecyclerItem: OnClickRecyclerItem) :
    RecyclerView.Adapter<SectionFavoriteAdapter.SectionHolder>() {
    private var itemsOfFavorite = mutableListOf<SectionEntity>()
    private lateinit var onClickDeleteBtn : OnDeleteItemFromFavListener

    fun setOnDeleteFromFav(onDeleteItemFromFavListener: OnDeleteItemFromFavListener){
        this.onClickDeleteBtn = onDeleteItemFromFavListener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.section_item, parent, false)
        return SectionHolder(view)
    }

    override fun onBindViewHolder(holder: SectionHolder, position: Int) {
        holder.bind(itemsOfFavorite[position], onClickRecyclerItem,onClickDeleteBtn)

    }

    override fun getItemCount() = itemsOfFavorite.size

    inner class SectionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var textSection: TextView
        lateinit var deleteFavBtn: ImageView

        fun bind(response: SectionEntity, onClickRecyclerItem: OnClickRecyclerItem,onDeleteItemFromFavListener: OnDeleteItemFromFavListener) {
            textSection = itemView.findViewById(R.id.favSection)
            deleteFavBtn = itemView.findViewById(R.id.deleteFavSec)
            textSection.text = response.webTitle

            itemView.setOnClickListener {
                onClickRecyclerItem.onItemClick(response.id)
            }
            deleteFavBtn.setOnClickListener {
                onDeleteItemFromFavListener.onClickDeleteBtn(response)
            }
        }

    }

    fun updateList(resultsItem: List<SectionEntity>) {
        itemsOfFavorite.clear()
        itemsOfFavorite.addAll(resultsItem)
        notifyDataSetChanged()
    }
}