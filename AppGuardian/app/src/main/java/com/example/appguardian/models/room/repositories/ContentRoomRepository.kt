package com.example.appguardian.models.room.repositories

import androidx.lifecycle.LiveData
import com.example.appguardian.models.room.dao.ContentDao
import com.example.appguardian.models.room.entity.ContentEntity

class ContentRoomRepository (private val contentDao: ContentDao) {
    val  allContentFromRoom:LiveData<List<ContentEntity>> = contentDao.getAllFavoriteContents()

    fun insertContent(content:ContentEntity){
        contentDao.insert(content)
    }
    fun deleteContentById(id:String){
        contentDao.deleteById(id)
    }
}