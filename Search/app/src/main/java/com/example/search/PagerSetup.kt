package com.example.search

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerSetup(fragmentActivity: FragmentActivity,private var listFr:List<Fragment>) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = listFr.size

    override fun createFragment(position: Int): Fragment {
        return  listFr[position]
    }
}