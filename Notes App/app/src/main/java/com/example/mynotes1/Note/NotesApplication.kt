package com.example.mynotes1.Note

import android.app.Application

class NotesApplication : Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { NoteRoomDataBase.getDatabase(this) }
    val repository by lazy { NoteRepository(database.noteDao()) }
}