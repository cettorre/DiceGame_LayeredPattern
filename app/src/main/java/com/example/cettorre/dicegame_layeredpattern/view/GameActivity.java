package com.example.cettorre.dicegame_layeredpattern.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cettorre.dicegame_layeredpattern.R;
import com.example.cettorre.dicegame_layeredpattern.application.GameController;
import com.example.cettorre.dicegame_layeredpattern.domain.Game;
import com.example.cettorre.dicegame_layeredpattern.domain.Player;

import static com.example.cettorre.dicegame_layeredpattern.view.PlayerActivity.gameController;

public class GameActivity extends AppCompatActivity {

    Button btnPlay;
    Button btnStop;
    TextView tvWelcome;
    TextView tvDice1;
    TextView tvDice2;
    TextView tvHasWon;
    TextView tvVictories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initComponents();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=getIntent();
                int pos= i.getIntExtra("position",0);
                Player player=gameController.getCurrentPLayer(pos);
                Log.e("player",player.toString());
                player.addGame(new Game());
                Game game=player.getCurrentGame();
                player.rollDices();
                int dice1= player.getDice1Value();

                Log.e("dice1",String.valueOf(dice1));

                //TODO usar DTO


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
