package com.example.notesapp

import android.content.Context
import androidx.compose.ui.text.android.animation.SegmentType
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Database(entities = arrayOf(Note::class),version = 1,exportSchema = false)
public abstract class NotesRoomDatabase : RoomDatabase(){

    abstract fun noteDao() : NotesDao



    private class NoteDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.noteDao())
                }
            }
        }

        suspend fun populateDatabase(noteDao: NotesDao) {
            // Delete all content here.
            noteDao.deleteAll()

            // Add sample words.
            var word = Note("Hello")
            noteDao.insert(word)
            word = Note("World!")
            noteDao.insert(word)


        }
    }

    companion object{
        // Singleton prevents multiple instances of database opening at the
        // same time.

        @Volatile
        private var INSTANCE : NotesRoomDatabase?= null

        fun getDatabase(context: Context, scope: CoroutineScope) : NotesRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotesRoomDatabase::class.java,
                    "note_database"
                ) .addCallback(NoteDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }

        }

    }
}