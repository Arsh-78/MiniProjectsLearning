package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button but = (Button)findViewById(R.id.button);
        EditText ed = (EditText)findViewById(R.id.Numb);





       but.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {


               Number no = new Number();
               if (ed.getText().toString().isEmpty()) {
                   Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_LONG).show();
               } else {


                   no.number = Integer.parseInt(ed.getText().toString());

                   ed.onEditorAction(EditorInfo.IME_ACTION_DONE);
                   String fm = ed.getText().toString();

                   String message;


                   if (no.isSquareNumber() && no.isTriangular()) {
                       message = fm + "Is both a square and triangular number";
                       Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                   } else if (no.isSquareNumber() && !no.isTriangular()) {
                       message = fm + "Is a Squarenumber";
                       Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                   } else if (!no.isSquareNumber() && no.isTriangular()) {
                       message = fm + "Is a Triangular Numer";
                       Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                   } else {
                       message = fm + "Neither a square nor a triangular number";
                       Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                   }

               }
           }
       });

    }

    public class Number
    {
        int number;

        public boolean isTriangular()
        {
            int x=1;
            int triangularNumber = 1;
            while(triangularNumber<number)
            {
                x++;
                triangularNumber += x;
            }
            if(triangularNumber==number)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public boolean isSquareNumber()
        {
            double sqroot=Math.sqrt(number);
            if(sqroot == Math.floor((sqroot)))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

    }
}