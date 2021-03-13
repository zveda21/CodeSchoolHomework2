package com.example.appguardian.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FavoriteFragmentPager(fragmentActivity: FragmentActivity, private var favFragments: List<Fragment>) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = favFragments.size

    override fun createFragment(position: Int): Fragment {
        return favFragments[position]
    }
}