package com.example.hw8_7mon.ui.fragments.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw8_7mon.data.model.Note
import com.example.hw8_7mon.data.model.NoteEntity
import com.example.hw8_7mon.data.repositories.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class NoteViewModel(private val repository: NoteRepository) : ViewModel() {

    private val _allNotes = MutableLiveData<List<Note>>()
    val allNotes: Flow<List<NoteEntity>> = repository.getAllNotes()

    fun searchNotes(query: String, category: String){
        viewModelScope.launch {
            _allNotes.value = repository.searchNotes(query, category)
        }
    }

    fun addNote(note: NoteEntity) {
        viewModelScope.launch {
            repository.addNote(note)
        }
    }

    fun updateNote(note: NoteEntity) {
        viewModelScope.launch {
            repository.updateNote(note)
        }
    }

    fun deleteNote(note: NoteEntity) {
        viewModelScope.launch {
            repository.deleteNote(note)
        }
    }
}