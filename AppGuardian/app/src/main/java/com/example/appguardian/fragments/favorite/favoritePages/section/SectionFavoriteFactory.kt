package com.example.appguardian.fragments.favorite.favoritePages.section

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appguardian.models.room.repositories.SectionRoomRepository

class SectionFavoriteFactory (private val sectionRoomRepository: SectionRoomRepository ):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SectionFavoriteViewModel::class.java)) {
        return SectionFavoriteViewModel(sectionRoomRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}