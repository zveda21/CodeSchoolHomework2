package com.example.appguardian.models.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "content_table")
data class ContentEntity (
    @PrimaryKey @ColumnInfo(name = "id") val id:String,
    @ColumnInfo(name = "webTitle")val webTitle:String,
    @ColumnInfo(name = "sectionName")val sectionName: String,
    @ColumnInfo(name = "thumbnail") val thumbnail: String,
)