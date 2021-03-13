package com.example.appguardian.models.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appguardian.models.room.dao.ContentDao
import com.example.appguardian.models.room.dao.SectionDao
import com.example.appguardian.models.room.entity.ContentEntity
import com.example.appguardian.models.room.entity.SectionEntity


@Database(
    entities = [ ContentEntity::class, SectionEntity::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun contentDao(): ContentDao
    abstract fun sectionDao(): SectionDao

    companion object {
        private const val FAVORITE_DB_NAME = "Favorite"
        private var favInstance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            return favInstance?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, FAVORITE_DB_NAME).allowMainThreadQueries().build()

                favInstance= instance
                instance
            }
        }
    }
}