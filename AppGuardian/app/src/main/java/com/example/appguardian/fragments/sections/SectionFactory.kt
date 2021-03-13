package com.example.appguardian.fragments.sections

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appguardian.callservice.SearchRepository
import com.example.appguardian.models.room.repositories.SectionRoomRepository

class SectionFactory (private val repository: SearchRepository, private val sectionRoomRepository: SectionRoomRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SectionViewModel(repository,sectionRoomRepository) as T
    }

}