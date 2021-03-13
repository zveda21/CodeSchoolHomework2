package com.example.appguardian.models.room.repositories

import androidx.lifecycle.LiveData
import com.example.appguardian.models.room.dao.SectionDao
import com.example.appguardian.models.room.entity.SectionEntity

class SectionRoomRepository(private val sectionDao: SectionDao) {

    val allSectionFromRoom :LiveData<List<SectionEntity>> = sectionDao.getAllFavoriteSections()
    fun insertSection(section:SectionEntity){
        sectionDao.insert(section)
    }
    fun updateSection(section: SectionEntity){
        sectionDao.update(section)
    }
    fun deleteAllSection(){
        sectionDao.deleteAll()
    }
    fun deleteSectionById(id:String){
        sectionDao.deleteById(id)
    }
}