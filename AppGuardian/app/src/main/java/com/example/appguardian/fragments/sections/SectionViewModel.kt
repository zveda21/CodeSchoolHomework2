package com.example.appguardian.fragments.sections

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appguardian.base.BaseSearchViewModel
import com.example.appguardian.callservice.ApiCallback
import com.example.appguardian.callservice.SearchRepository
import com.example.appguardian.models.pojo.Section
import com.example.appguardian.models.room.entity.SectionEntity
import com.example.appguardian.models.room.repositories.SectionRoomRepository

class SectionViewModel(private val searchRepository: SearchRepository, private val sectionRoomRepository: SectionRoomRepository) : BaseSearchViewModel() {

    private var _sectionsLiveData = MutableLiveData<List<Section.Response.Result>?>()
    var sectionsLiveData: LiveData<List<Section.Response.Result>?> = _sectionsLiveData
    private var storageOfSectionData = mutableListOf<Section.Response.Result>()

    private var _roomListSection :LiveData<List<SectionEntity>> = MutableLiveData()
    var  roomListOfSection :LiveData<List<SectionEntity>> = _roomListSection
    init {
        _roomListSection = sectionRoomRepository.allSectionFromRoom
    }


    fun getSection(){
        searchRepository.sections(object :ApiCallback<Section>{
            override fun onSuccess(data: Section?) {
                if (data!=null){
                    storageOfSectionData.clear()
                    data.response?.results?.let { storageOfSectionData.addAll(it) }
                    checkFavorite()
                }

            }
        })
    }

    fun checkFavorite(){
        storageOfSectionData.forEach { resultsItem ->
            _roomListSection.value?.forEach {
                if (resultsItem.id==it.id){
                    resultsItem.favorite = true
                }
            }
        }
        _sectionsLiveData.value = storageOfSectionData
    }
    fun updateRoomData(resultsItem: Section.Response.Result,position:Int, isChecked:Boolean){
        storageOfSectionData[position].favorite = isChecked
        if (isChecked){
            resultsItem.id?.let { resultsItem.webTitle?.let { it1 -> SectionEntity(it, it1) } }?.let {
                sectionRoomRepository.insertSection(
                    it
                )
            }
        }else
            if (!isChecked){
                resultsItem.id?.let { sectionRoomRepository.deleteSectionById(it) }
            }
    }
}


