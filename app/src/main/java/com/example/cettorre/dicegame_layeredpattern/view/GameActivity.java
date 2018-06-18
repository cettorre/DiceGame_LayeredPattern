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
import com.example.cettorre.dicegame_layeredpattern.application.dto.GameDTO;
import com.example.cettorre.dicegame_layeredpattern.application.dto.PlayerDTO;


public class GameActivity extends AppCompatActivity {

    Button btnPlay;
    Button btnStop;
    TextView tvWelcome;
    TextView tvDice1;
    TextView tvDice2;
    TextView tvHasWon;
    TextView tvVictories;
    boolean hasWon;
    GameController gameController= new GameController();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initComponents();

        tvWelcome.setText("Welcome ");

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GameDTO game=null;

                try {
                    game=gameController.playGame();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                hasWon=game.isHasWon();
                if (hasWon){
                    tvHasWon.setText("Congratulations you win!");
                }else {
                    tvHasWon.setText("You have lost. Try Again.");
                }


                tvDice1.setText(String.valueOf(game.getDiceValue1()));
                tvDice2.setText(String.valueOf(game.getDiceValue2()));

                PlayerDTO player=gameController.getPlayer();
                tvVictories.setText(String.format("%.2f",player.getPercentageOfVictories())+"%");
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
