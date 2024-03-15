package com.example.hw8_7mon.data.repositories

import com.example.hw8_7mon.data.local.NoteDao
import com.example.hw8_7mon.data.model.Note
import com.example.hw8_7mon.data.model.NoteEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class NoteRepository(private val noteDao: NoteDao) {

    fun getAllNotes(): Flow<List<NoteEntity>>{
        return noteDao.getAllNotes()
    }

    suspend fun searchNotes(query: String, category: String): List<Note>{
        return withContext(Dispatchers.IO){
            noteDao.searchNotes(query, category)
        }
    }

    suspend fun addNote(note: NoteEntity){
        noteDao.addNote(note)
    }

    suspend fun updateNote(note: NoteEntity){
        noteDao.updateNote(note)
    }

    suspend fun deleteNote(note: NoteEntity){
        noteDao.deleteNote(note)
    }
}