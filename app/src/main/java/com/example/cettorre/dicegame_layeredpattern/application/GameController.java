package com.example.cettorre.dicegame_layeredpattern.application;

import android.util.Log;

import com.example.cettorre.dicegame_layeredpattern.application.dto.GameDTO;
import com.example.cettorre.dicegame_layeredpattern.application.dto.PlayerDTO;
import com.example.cettorre.dicegame_layeredpattern.domain.Game;
import com.example.cettorre.dicegame_layeredpattern.domain.Player;

import java.util.ArrayList;
import java.util.List;


public class GameController {

    private static Player player;
    private static Game game;

    public static Player getPlayer() {
        return player;
    }

    public void createPlayer(String name) {
        this.player = new Player(name);
        Log.e("created player", "created");
    }

//    PlayerDTO playerDTO= new PlayerDTO(player);
//    GameDTO gameDTO= new GameDTO(game);

    //TODO puedo poner esta list en controller?
    private List<Player> playersList = new ArrayList<>();

    //TODO Donde hay que instanciar DTO
    //private PlayerDTO playerDTO= new PlayerDTO();


    public void addPlayerToList(Player player) {
        playersList.add(player);
    }

    public List getPlayersList() {

        return playersList;
    }

    public Player getCurrentPLayer(int i) {

        return playersList.get(i);
    }

    public static Game getGame() {
        return game;
    }

    public String getPlayerName() {	return player.getName();}



    public int getDice1Value(){	return player.getDice1Value();}

    public int getDice2Value(){	return player.getDice2Value();}

    public void resetGamesList(){player.resetGamesList();}

    public int getRolledTimes(){ return player.getAllGames().size();}

    public Game getIndexGame(int i){ return player.getAllGames().get(i);
    }

    public double getTotalAverage(){return player.getFinalScore();
    }



}
