package com.example.appguardian

import android.app.Application
import androidx.room.RoomDatabase
import com.example.appguardian.models.room.db.AppDatabase
import com.example.appguardian.models.room.repositories.ContentRoomRepository
import com.example.appguardian.models.room.repositories.RoomRepository
import com.example.appguardian.models.room.repositories.SectionRoomRepository

class GuardianApplication:Application() {
    private val database by lazy {  AppDatabase.getInstance(this) }
    val repository by lazy { RoomRepository(database.contentDao(), database.sectionDao()) }
    val sectionRepository by lazy { SectionRoomRepository(database.sectionDao()) }
    val contentRepository by lazy { ContentRoomRepository(database.contentDao()) }
}