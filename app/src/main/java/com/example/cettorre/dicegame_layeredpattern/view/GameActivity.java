package com.example.cettorre.dicegame_layeredpattern.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cettorre.dicegame_layeredpattern.R;
import com.example.cettorre.dicegame_layeredpattern.application.dto.GameDTO;
import com.example.cettorre.dicegame_layeredpattern.application.dto.PlayerDTO;


import static com.example.cettorre.dicegame_layeredpattern.view.PlayerActivity.gameController;

public class GameActivity extends AppCompatActivity {

    Button btnPlay;
    Button btnStop;
    TextView tvWelcome;
    TextView tvDice1;
    TextView tvDice2;
    TextView tvHasWon;
    TextView tvVictories;
    boolean hasWon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initComponents();
        Intent i=getIntent();
        int pos= i.getIntExtra("position",0);
        tvWelcome.setText("Welcome "+gameController.getCurrentPLayer(pos).getName());

        tvVictories.setText(String.format("%.2f",gameController.getCurrentPLayer(pos).getPlayerRanking())+"%");


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=getIntent();
                int pos= i.getIntExtra("position",0);

                gameController.getCurrentPLayer(pos).addGame();

                gameController.getCurrentPLayer(pos);

                hasWon=gameController.getCurrentPLayer(pos).rollDices();
                if (hasWon){
                    tvHasWon.setText("Congratulations you win!");
                }else {
                    tvHasWon.setText("You have lost. Try Again.");
                }
                int dice1= gameController.getCurrentPLayer(pos).getDice1Value();
                int dice2= gameController.getCurrentPLayer(pos).getDice2Value();



                Log.e("player",gameController.getCurrentPLayer(pos).toString());
                Log.e("dice1",String.valueOf(dice1));
                Log.e("dice2",String.valueOf(dice2));
                Log.e("games2",gameController.getCurrentPLayer(pos).getAllGames().toString());



                //TODO usar DTO



                //TODO averiguar porque estos valores son diferentes y borrar
            //    tvDice1.setText(String.valueOf(gameController.getDice1Value()));
            //    tvDice2.setText(String.valueOf(gameController.getDice2Value()));

                tvDice1.setText(String.valueOf(gameController.getCurrentPLayer(pos).getDice1Value()));
                tvDice2.setText(String.valueOf(gameController.getCurrentPLayer(pos).getDice2Value()));
                tvVictories.setText(String.format("%.2f",gameController.getCurrentPLayer(pos).getPlayerRanking())+"%");
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameActivity.this,PlayerActivity.class);
                startActivity(i);
            }
        });
    }

    public void initComponents(){
        btnPlay=findViewById(R.id.btn_play_game);
        btnStop=findViewById(R.id.btn_stop_game);
        tvWelcome=findViewById(R.id.tv_welcome);
        tvDice1=findViewById(R.id.tv_dice1);
        tvDice2=findViewById(R.id.tv_dice2);
        tvHasWon=findViewById(R.id.tv_has_won);
        tvVictories=findViewById(R.id.tv_victories);
    }
}
