package com.example.appguardian.fragments.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.appguardian.MainActivity
import com.example.appguardian.adapters.FavoriteFragmentPager
import com.example.appguardian.base.BaseSportFragment
import com.example.appguardian.databinding.FragmentFavoriteBinding
import com.example.appguardian.fragments.favorite.favoritePages.content.ContentFavorite
import com.example.appguardian.fragments.favorite.favoritePages.section.SectionFavorite
import com.google.android.material.tabs.TabLayoutMediator


 class FavoriteFragment : BaseSportFragment() {
    private lateinit var favoriteBinding: FragmentFavoriteBinding
    private lateinit var listOfFavorite :List<Fragment>
    private lateinit var pagerAdapter :FavoriteFragmentPager
    override fun startLoader() {
        TODO("Not yet implemented")
    }

    override fun stopLoader() {
        TODO("Not yet implemented")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        favoriteBinding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return favoriteBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         setupPager()
    }

    fun setupPager() {
        listOfFavorite = listOf(SectionFavorite.newInstance(), ContentFavorite.newInstance())
        pagerAdapter = FavoriteFragmentPager(reqActivity(), listOfFavorite)
        favoriteBinding.favoriteVP.adapter = pagerAdapter
        TabLayoutMediator(favoriteBinding.favoriteTab, favoriteBinding.favoriteVP) { tab, position ->
            when(position) {
                0 -> {
                    tab.text = "Section"
                }
                1 -> {
                    tab.text = "Content"
                }
            }
        }.attach()

    }


    private fun reqActivity(): MainActivity {
        return requireActivity() as MainActivity
    }

    companion object {
        fun newInstance() = FavoriteFragment()
    }
}