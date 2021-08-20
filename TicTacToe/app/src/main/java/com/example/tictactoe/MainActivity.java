package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean GameActive = true;
    // 0 - X player
    // 1 - 0 player
    int ActivePlayer = 0;
    int[] GameState = {2,2,2,2,2,2,2,2,2};
    // 0-X(X IN GAME)
    // 1-0(0 IN GAME)
    // 2-blank
    int[][] WinPositions = {{0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}};
    public void playerTap(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!GameActive){
            gameReset(view);
        }
        if(GameState[tappedImage] == 2) {
            GameState[tappedImage] = ActivePlayer;
            img.setTranslationY(-1000f);
            if (ActivePlayer == 0) {
                img.setImageResource(R.drawable.x);
                ActivePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn - Tap to play");
            } else {
                img.setImageResource(R.drawable.o);
                ActivePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn - Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);



        }

        for(int[] winPosition: WinPositions){
            if(GameState[winPosition[0]] == GameState[winPosition[1]] &&
                    GameState[winPosition[1]] == GameState[winPosition[2]] &&
                    GameState[winPosition[0]]!=2){

                String winnerStr;
                GameActive = false;
                if(GameState[winPosition[0]] == 0){
                    winnerStr = "X has won";
                }
                else{
                    winnerStr = "O has won";
                }

                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);

            }



        }

    }

    public void gameReset(View view) {
        GameActive = true;
        ActivePlayer = 0;
        for(int i=0; i<GameState.length; i++){
            GameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap to play");

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnReset = (Button)findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameActive = true;
                ActivePlayer = 0;
                for(int i=0; i<GameState.length; i++){
                    GameState[i] = 2;
                }
                ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

                TextView status = findViewById(R.id.status);
                status.setText("X's Turn - Tap to play");

            }
        });

    }
}
