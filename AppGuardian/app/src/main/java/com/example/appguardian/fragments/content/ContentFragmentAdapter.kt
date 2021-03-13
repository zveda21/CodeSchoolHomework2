package com.example.appguardian.fragments.content

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appguardian.R
import com.example.appguardian.fragments.sections.OnClickRecyclerItem
import com.example.appguardian.models.pojo.Content

class ContentFragmentAdapter (var onClickRecyclerItem: OnClickRecyclerItem) : RecyclerView.Adapter<ContentFragmentAdapter.ContentViewHolder>() {
    private var items = mutableListOf<Content.Response.Result>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_recycler_item, parent, false)
        return ContentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(items[position], onClickRecyclerItem)

    }

    override fun getItemCount(): Int = items.size

    class ContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var sectionName: TextView
        lateinit var webPubTv: TextView
        lateinit var thumbnailImg: ImageView
        fun bind(response: Content.Response.Result, onClickRecyclerItem: OnClickRecyclerItem) {
            sectionName = itemView.findViewById(R.id.sectionNameTV)
            webPubTv = itemView.findViewById(R.id.webTitleTv)
            thumbnailImg = itemView.findViewById(R.id.thumbnailImg)
            sectionName.text = response.fields.byline
            webPubTv.text = response.webTitle
            response.fields.thumbnail.let {
                Glide.with(itemView.context)
                    .load(it)
                    .into(thumbnailImg)
            }
            itemView.setOnClickListener {
                onClickRecyclerItem.onItemClick(response)
            }
        }
    }

    fun updateDate(listOfSections: List<Content.Response.Result>?) {
        listOfSections?.let {
            items.clear()
            items.addAll(listOfSections)
            notifyDataSetChanged()
        }
    }
}