package com.example.appguardian.models.room.repositories

import com.example.appguardian.models.room.dao.ContentDao
import com.example.appguardian.models.room.dao.SectionDao

class RoomRepository (private val contentDao: ContentDao,private val sectionDao: SectionDao){

    fun deleteAllFavorite(){
        contentDao.deleteAll()
        sectionDao.deleteAll()
    }
}