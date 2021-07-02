package com.example.mynotes1.Note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.mynotes1.R

class ModifyNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify_note)
        val dnote =intent.getStringExtra("EXTRA_NOTE")
        val textView:TextView= findViewById(R.id.info_text)
        textView.text=dnote
    }
}