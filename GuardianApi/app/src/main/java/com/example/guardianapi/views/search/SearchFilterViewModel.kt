package com.example.guardianapi.views.search

import androidx.lifecycle.MutableLiveData
import com.example.guardianapi.base.BaseViewModel
import com.example.guardianapi.models.ResultsItem

class SearchFilterViewModel: BaseViewModel() {
    val searchDataLive = MutableLiveData<ResultsItem>()

    fun getUpdates(){
        dataLoading.value = true

    }
}