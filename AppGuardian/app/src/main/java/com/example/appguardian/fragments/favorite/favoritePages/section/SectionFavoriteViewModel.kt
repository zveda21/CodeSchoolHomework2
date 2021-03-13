package com.example.appguardian.fragments.favorite.favoritePages.section

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appguardian.models.room.entity.SectionEntity
import com.example.appguardian.models.room.repositories.SectionRoomRepository

class SectionFavoriteViewModel(private val sectionRoomRepository: SectionRoomRepository) :ViewModel(){
    private var _getFavoriteSection = MutableLiveData<List<SectionEntity>>()
    var getFavoriteSection: LiveData<List<SectionEntity>?> = _getFavoriteSection

    fun getSection() {
        _getFavoriteSection.value = sectionRoomRepository.allSectionFromRoom.value
    }

    val sectionsRoom = sectionRoomRepository.allSectionFromRoom

    fun deleteSectionById(id: String) {
        sectionRoomRepository.deleteSectionById(id)
    }

}