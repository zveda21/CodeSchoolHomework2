package com.example.appguardian.fragments.favorite

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.appguardian.models.room.repositories.RoomRepository


class FavoriteViewModel(private val roomRepository: RoomRepository) : ViewModel() {

    fun deleteAllFavorite() = roomRepository.deleteAllFavorite()

}