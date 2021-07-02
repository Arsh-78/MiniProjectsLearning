package com.example.mynotes1.Note

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM  Note_table Order by id ASC")
    fun getNotes(): Flow<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Query("DELETE FROM Note_table")
    suspend fun deleteAll()
}
