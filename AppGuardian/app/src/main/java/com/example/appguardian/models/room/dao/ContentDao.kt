package com.example.appguardian.models.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.appguardian.models.room.entity.ContentEntity

@Dao
interface ContentDao {
    @Query("SELECT * FROM content_table ORDER BY webTitle ASC")
    fun getAllFavoriteContents(): LiveData<List<ContentEntity>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(contentRoom: ContentEntity)
    @Query("DELETE FROM content_table")
    fun deleteAll()
    @Query("DELETE FROM content_table WHERE content_table.id=:id")
    fun deleteById(id:String)
    @Query("SELECT count(*) FROM content_table WHERE content_table.id = :id")
    fun checkContent(id:String):Int
}