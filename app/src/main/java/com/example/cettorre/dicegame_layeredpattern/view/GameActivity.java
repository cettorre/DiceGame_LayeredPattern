package com.example.cettorre.dicegame_layeredpattern.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.cettorre.dicegame_layeredpattern.R;
import com.example.cettorre.dicegame_layeredpattern.application.GameController;
import com.example.cettorre.dicegame_layeredpattern.application.dto.GameDTO;
import com.example.cettorre.dicegame_layeredpattern.application.dto.PlayerDTO;


public class GameActivity extends AppCompatActivity {

    private Button btnPlay;
    private TextView tvDice1,tvDice2, tvHasWon,tvVictories;

    private GameController gameController= new GameController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initComponents();

        btnPlay.setOnClickListener(createPlayListener());
    }

    private View.OnClickListener createPlayListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame();
            }
        };
    }
    private void playGame(){
        try {
            GameDTO game=gameController.playGame();
            checkIfWin(game);
            setDicesText(game);
            setVictoriesTextView();
        } catch (Exception e) {
            Toast toast= Toast.makeText(GameActivity.this, "Error en la aplicacion",Toast.LENGTH_LONG);
            toast.show();
        }
    }

    private void checkIfWin(GameDTO game){
        boolean hasWon=game.isHasWon();
        if (hasWon){
            tvHasWon.setText("Congratulations you win!");
        }else {
            tvHasWon.setText("You have lost. Try Again.");
        }
    }

    private void setDicesText(GameDTO game){
        tvDice1.setText(String.valueOf(game.getDiceValue1()));
        tvDice2.setText(String.valueOf(game.getDiceValue2()));
    }

    private void setVictoriesTextView(){
        try {
            PlayerDTO player = gameController.getPlayer();
            tvVictories.setText(String.format("%.2f",player.getPercentageOfVictories())+"%");
        } catch (Exception e) {
            Toast toast= Toast.makeText(GameActivity.this, "Error en la aplicacion",Toast.LENGTH_LONG);
            toast.show();
        }

    }

    private void initComponents(){
        btnPlay=findViewById(R.id.btn_play_game);
        tvDice1=findViewById(R.id.tv_dice1);
        tvDice2=findViewById(R.id.tv_dice2);
        tvHasWon=findViewById(R.id.tv_has_won);
        tvVictories=findViewById(R.id.tv_victories);
    }
}
