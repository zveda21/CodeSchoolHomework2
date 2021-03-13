package com.example.appguardian.fragments.content

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appguardian.base.BaseSearchViewModel
import com.example.appguardian.callservice.ApiCallback
import com.example.appguardian.callservice.SearchRepository
import com.example.appguardian.models.pojo.Content

class ContentViewModel(private val searchRepository: SearchRepository) : BaseSearchViewModel() {
    private var _contentLiveData = MutableLiveData<List<Content.Response.Result>?>()
    var contentLiveData: LiveData<List<Content.Response.Result>?> = _contentLiveData

    private var storageContentData = mutableListOf<Content.Response.Result>()


    fun getContent(orderBy: String?,usedDate: String?,q:String?) {
        searchRepository.contentDefaultSearch(orderBy,usedDate,q, object : ApiCallback<Content> {
            override fun onSuccess(data: Content?) {
                _contentLiveData.value = data
            }
        })
    }
}