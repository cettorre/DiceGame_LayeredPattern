package com.example.cettorre.dicegame_layeredpattern.view;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.cettorre.dicegame_layeredpattern.R;
import com.example.cettorre.dicegame_layeredpattern.application.GameController;
import com.example.cettorre.dicegame_layeredpattern.domain.Player;

import java.util.List;


public class PlayerActivity extends AppCompatActivity {

    EditText etNewPayer;
    Button btnNewPlayer;
    ListView listPlayers;
    static GameController gameController= new GameController();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        initComponents();

        List playersList=gameController.getPlayersList();

        ArrayAdapter<Player> adapter = new ArrayAdapter<Player>(
                this, android.R.layout.simple_list_item_1,playersList);
        listPlayers.setAdapter(adapter);


        btnNewPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String et=etNewPayer.getText().toString();
                Player player= gameController.createPlayer(et);
                gameController.addPlayerToList(player);

                Intent i =new  Intent(PlayerActivity.this, GameActivity.class);
                int pos=gameController.getPlayersList().size()-1;
                i.putExtra("position",pos);
                startActivity(i);
                Log.e("players", gameController.getPlayersList().toString());
                Log.e("size",String.valueOf(gameController.getPlayersList().size()));

            }
        });


    }

    public void initComponents(){
        btnNewPlayer=findViewById(R.id.btn_new_player);
        listPlayers=findViewById(R.id.list_players);
        etNewPayer=findViewById(R.id.et_new_player);

    }

}
