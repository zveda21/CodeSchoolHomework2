package com.example.appguardian.fragments.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appguardian.fragments.details.DetailsViewModel
import com.example.appguardian.models.room.repositories.RoomRepository

class FavoriteFactory(private val roomRepository: RoomRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FavoriteViewModel(roomRepository) as T
    }
}