package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int player = 0;
    int[] gameState= {2,2,2,2,2,2,2,2,2};
    int[][] winstates= { {0,1,2},{3,4,5} ,{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameRun = true;
    //0->Cross 1->Circle

    public void dropin(View view){
        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedCounter]==2 && gameRun) {
            gameState[tappedCounter] = player;
            counter.setTranslationY(-1500);
            if (player == 0) {
                counter.setImageResource(R.drawable.cr2);
                player = 1;
            } else {
                counter.setImageResource(R.drawable.cir2);
                player = 0;
            }
            counter.animate().translationYBy(1500).setDuration(300);
            for (int[] winningPosition : winstates) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                    String winner = "";
                    gameRun=false;
                    if (player == 0) {
                        winner = "Circle";
                    } else {
                        winner = "Cross";
                    }
                    Toast.makeText(this, winner + " winss !!", Toast.LENGTH_LONG).show();
                    TextView t=(TextView)findViewById(R.id.textView);
                    t.setText(winner+" has won");
                    Button b=(Button)findViewById(R.id.button);
                    t.setVisibility(View.VISIBLE);
                    b.setVisibility(View.VISIBLE);


                }
                else if( gameRun)
                {
                    for(int positionfilled : gameState)
                    {
                        if(positionfilled==0 || positionfilled==1)
                        {
                            gameRun= false;
                        }
                        else
                        {
                            gameRun=true;
                            break;
                        }
                    }
                    if(!gameRun)
                    {
                        Button b=(Button)findViewById(R.id.button);
                        b.setVisibility(View.VISIBLE);
                    }
                }

            }
        }

    }
    public void playAgain(View view)
    {

        TextView t=(TextView)findViewById(R.id.textView);

        Button b=(Button)findViewById(R.id.button);
        t.setVisibility(View.INVISIBLE);
        b.setVisibility(View.INVISIBLE);
        GridLayout l = (GridLayout)findViewById(R.id.gridLayout);
        for(int i = 0; i < l.getChildCount(); i++) {
            ImageView child = (ImageView) l.getChildAt(i);
            child.setImageDrawable(null);


        }
        player = 0;
        for(int i=0;i<gameState.length;i++)
        {
            gameState[i]=2;
        }
        gameRun = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}