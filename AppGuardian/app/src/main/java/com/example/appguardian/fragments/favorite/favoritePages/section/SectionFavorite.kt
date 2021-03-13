package com.example.appguardian.fragments.favorite.favoritePages.section

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.appguardian.GuardianApplication
import com.example.appguardian.databinding.FragmentSectionFavoriteBinding
import com.example.appguardian.fragments.favorite.FavoriteViewModel
import com.example.appguardian.fragments.favorite.OnDeleteItemFromFavListener
import com.example.appguardian.fragments.sections.OnClickRecyclerItem
import com.example.appguardian.fragments.sections.SectionFactory
import com.example.appguardian.models.room.entity.SectionEntity


class SectionFavorite : Fragment(), OnClickRecyclerItem , OnDeleteItemFromFavListener {
    private lateinit var sectionFavoriteBinding: FragmentSectionFavoriteBinding
    private lateinit var sectionFavoriteAdapter: SectionFavoriteAdapter
    private val sectionFavoriteViewModel : SectionFavoriteViewModel
//    by lazy { ViewModelProvider(this,
//        SectionFavoriteFactory((requireActivity().application as GuardianApplication).sectionRepository)).get(SectionFavoriteViewModel::class.java)}
    by viewModels {
        SectionFavoriteFactory((requireActivity().application as GuardianApplication).sectionRepository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sectionFavoriteViewModel.getSection()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        sectionFavoriteBinding = FragmentSectionFavoriteBinding.inflate(inflater, container, false)
        sectionFavoriteAdapter = SectionFavoriteAdapter(this)
        return sectionFavoriteBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()

        sectionFavoriteViewModel.getFavoriteSection.observe(viewLifecycleOwner, Observer {
            it?.let { it1 -> sectionFavoriteAdapter.updateList(it1) }
        })
    }

    private fun setupAdapter() {
        sectionFavoriteBinding.sectionFavRecycler.adapter = sectionFavoriteAdapter
        sectionFavoriteAdapter.setOnDeleteFromFav(this)
    }


    companion object {
        fun newInstance() = SectionFavorite()
    }

    override fun onItemClick(id: Any?) {
        TODO("Not yet implemented")
    }

    override fun onClickDeleteBtn(item: Any) {
        sectionFavoriteViewModel.deleteSectionById((item as SectionEntity).toString())
    }
}