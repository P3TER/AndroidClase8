package com.example.clase8.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.clase8.model.Note

@Composable
fun AddEditNoteForm(
    onAddNote: (String, String) -> Unit,
    onEditNote: (Int, String, String) -> Unit,
    noteToEdit: Note? =null
){
    var tittle by remember { mutableStateOf(noteToEdit?.tittle?: "") }
    var content by remember { mutableStateOf(noteToEdit?.content?: "") }
    
    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(value = tittle, onValueChange = {tittle = it},
            label = { Text(text = "Tittle")}, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = content, onValueChange = {content = it},
            label = { Text(text = "Content")}, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { if (noteToEdit == null){
            onAddNote(tittle, content)
        }else{
            onEditNote(noteToEdit.id, tittle, content)
        }
            tittle = ""
            content = "" }, modifier = Modifier.fillMaxWidth()) {
            Text(if(noteToEdit == null) "Add Note" else "Edit Note")
        }
    }
}