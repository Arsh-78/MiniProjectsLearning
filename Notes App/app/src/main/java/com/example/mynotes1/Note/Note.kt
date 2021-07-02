package com.example.mynotes1.Note

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "Note_table")
data class Note(@ColumnInfo (name = "Note") var note: String,@PrimaryKey(autoGenerate = true) val id: Int = 0)
