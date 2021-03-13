package com.example.appguardian.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentPagerAdapter(fragmentActivity: FragmentActivity, private val fragmentsList :MutableList<Fragment>) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount():Int = fragmentsList.size

    override fun createFragment(position: Int): Fragment {
        return fragmentsList[position]

    }
}