package com.example.clase8.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.clase8.model.Note

class NoteViewModel: ViewModel(){
    private val _notes = mutableStateListOf(
        Note(1, "First Note", "This is the content of the first note", System.currentTimeMillis()),
        Note(2, "Second Note", "This is the content of the second note", System.currentTimeMillis())
    )
    val notes: SnapshotStateList<Note> = _notes

    private var nextId = 3

    fun addNote(tittle: String, content: String){
        _notes.add(Note(nextId++, tittle, content, System.currentTimeMillis()))
    }

    fun editNote(id: Int, newTittle: String, newContent: String){
        val note = _notes.find { it.id ==id }

        note?.let{
            it.tittle = newTittle
            it.content = newContent
            it.timestamp = System.currentTimeMillis()
        }
    }

    fun deleteNote(id: Int){
        _notes.removeAll { it.id == id }
    }
}