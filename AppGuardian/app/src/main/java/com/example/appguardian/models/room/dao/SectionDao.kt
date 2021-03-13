package com.example.appguardian.models.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.appguardian.models.room.entity.SectionEntity

@Dao
interface SectionDao {
    @Query("DELETE FROM section_table WHERE section_table.id=:id")
    fun deleteById(id:String)
    @Query("SELECT * FROM section_table ORDER BY webTitle ASC")
    fun getAllFavoriteSections(): LiveData<List<SectionEntity>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(sectionRoom: SectionEntity)
    @Query("DELETE FROM section_table")
    fun deleteAll()
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(sectionRoom: SectionEntity)
}