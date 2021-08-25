package com.example.handl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        int ans= rand.nextInt(21);
        Button button=(Button)findViewById(R.id.button);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               EditText ed= (EditText)findViewById(R.id.YourGuess);
               int guess= Integer.parseInt(ed.getText().toString());
               if(guess > ans)
               {
                   Toast.makeText(MainActivity.this, "Lower", Toast.LENGTH_SHORT).show();
               }
               else if (guess<ans)
               {
                   Toast.makeText(MainActivity.this, "Higher", Toast.LENGTH_SHORT).show();
               }
               else
               {
                   Toast.makeText(MainActivity.this, "Congrats!! You guessed the correct number that is "+ ans, Toast.LENGTH_LONG).show();
               }

           }
       });

    }
}