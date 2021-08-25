package com.example.phrasesapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun playPhrase(view: View) {
        val button : Button= view as Button
        button.setOnClickListener{
            var mediaPlayer = MediaPlayer.create(this, resources.getIdentifier(view.tag.toString(),"raw",packageName))
            mediaPlayer.start() // no need to call prepare(); create() does that for you
        }

    }


}

