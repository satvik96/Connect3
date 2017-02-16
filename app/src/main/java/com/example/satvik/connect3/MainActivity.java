package com.example.satvik.connect3;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {

    int activePlayer=0;//yellow=0 red=1
    boolean gameActive=true;

int[] gameState={2,2,2,2,2,2,2,2,2};
int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void dropIn(View view) {

        ImageView counter = (ImageView) view;
        //counter.setTranslationY(-1000f);

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2&& gameActive) {

            gameState[tappedCounter]=activePlayer;

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;

            }   //counter.animate().translationY(1000f).setDuration(2000);

            for(int[] winningPosition:winningPositions){
                if(gameState[winningPosition[0]]==gameState[winningPosition[1]]&&gameState[winningPosition[1]]==gameState[winningPosition[2]]&&gameState[winningPosition[0]]!=2) {
                    {
                        gameActive=false;
                        String winner="red";
                        if(gameState[winningPosition[0]]==0)
                            winner="yellow";

                        System.out.println(gameState[winningPosition[0]]);
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText(winner+" Has Won!");
                        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
                        linearLayout.setVisibility(View.VISIBLE);
                    }

                }
            }



        }


    }

    public void playAgain(View view)
    {
        gameActive=true;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        linearLayout.setVisibility(View.INVISIBLE);
        activePlayer=0;
        for(int i=0;i<gameState.length;i++)
            gameState[i]=2;

        GridLayout gridLayout=(GridLayout)findViewById(R.id.gridLayout);
        for(int i=0;i<gridLayout.getChildCount();i++)
        {
            ((ImageView)gridLayout.getChildAt(i)).setImageResource(0);

        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
