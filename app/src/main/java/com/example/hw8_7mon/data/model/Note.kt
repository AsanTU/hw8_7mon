package com.example.hw8_7mon.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Note(
    val id:Long,
    val title:String,
    val content: String,
    val category: String,
    val priority: Int
)

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = "title")
    val title:String,

    @ColumnInfo(name = "content")
    val content: String,

    @ColumnInfo(name = "category")
    val category: String,

    @ColumnInfo(name = "priority")
    val priority: Int
)
