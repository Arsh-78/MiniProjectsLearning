package com.example.entersimpsons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView im=(ImageView)findViewById(R.id.imageView);
        im.animate().translationX(0).rotation(36000).setDuration(3000);
    }
}