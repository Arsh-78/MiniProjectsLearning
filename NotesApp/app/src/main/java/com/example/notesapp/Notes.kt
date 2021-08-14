package com.example.notesapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes_table")
class Note(@PrimaryKey @ColumnInfo(name = "note") val note: String)