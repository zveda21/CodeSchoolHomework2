package com.example.appguardian.fragments.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appguardian.base.BaseSearchViewModel
import com.example.appguardian.callservice.ApiCallback
import com.example.appguardian.callservice.SearchRepository
import com.example.appguardian.models.ditails.DitailsResponse
import com.example.appguardian.models.pojo.Description

class DetailsViewModel(private val searchRepository: SearchRepository) : BaseSearchViewModel() {
    private var _detailsLiveData = MutableLiveData<Description?>()
    val detailsLiveData: LiveData<Description?> = _detailsLiveData

    fun getSectionWithPath(id: String?) {
        searchRepository.currentSection(id, object : ApiCallback <Description> {
            override fun onSuccess(data: Description?) {
                _detailsLiveData.value = data
            }
        })
    }
}