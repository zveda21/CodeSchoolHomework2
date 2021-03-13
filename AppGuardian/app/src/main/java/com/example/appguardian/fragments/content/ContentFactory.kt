package com.example.appguardian.fragments.content

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appguardian.callservice.SearchRepository

class ContentFactory  (private val repository: SearchRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ContentViewModel(repository) as T
    }
}