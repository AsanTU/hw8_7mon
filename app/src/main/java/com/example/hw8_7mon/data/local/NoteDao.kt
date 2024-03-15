package com.example.hw8_7mon.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.hw8_7mon.data.model.Note
import com.example.hw8_7mon.data.model.NoteEntity

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    fun getAllNotes(): kotlinx.coroutines.flow.Flow<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE title LIKE '%' || :query || '%' AND category LIKE :category")
    suspend fun searchNotes(query: String, category: String): List<Note>

    @Insert
    suspend fun addNote(note: NoteEntity)

    @Update
    suspend fun updateNote(note: NoteEntity)

    @Delete
    suspend fun deleteNote(note: NoteEntity)
}