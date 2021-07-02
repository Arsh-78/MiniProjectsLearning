package com.example.mynotes1.Note

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class NotesApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { NoteRoomDataBase.getDatabase(this,applicationScope) }
    val repository by lazy { NoteRepository(database.noteDao()) }
}