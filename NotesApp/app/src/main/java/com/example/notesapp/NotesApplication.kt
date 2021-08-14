package com.example.notesapp

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class NotessApplication : Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts

    val applicationScope = CoroutineScope(SupervisorJob())


    val database by lazy { NotesRoomDatabase.getDatabase(this,applicationScope) }
    val repository by lazy { NoteRepository(database.noteDao()) }
}