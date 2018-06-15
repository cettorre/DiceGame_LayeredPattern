package com.example.cettorre.dicegame_layeredpattern.domain;

import android.util.Log;


import java.util.ArrayList;
import java.util.List;



public class Player {

    private String name;
    private Game game;
    double finalScore;


    private ArrayList<Game> games=new ArrayList<>();//change

    public Player(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void addGame(Game game){
        try{
            if (game==null) throw new Exception();
            games.add(game);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public List<Game> getAllGames() {return games;}

    public void resetGamesList(){games.clear();}

    public Game getGame() {
        return game;
    }

    public boolean rollDices() {
        game= new Game();
        game.getDice1().rollDice();
        game.getDice2().rollDice();

        Log.e("game_p_60",game.toString());
        addGame(game);
        Log.e("games_p_62",games.toString());

        return game.hasWon();}

    public int getDice1Value() { return game.getDice1().getValue();}

    public int getDice2Value() {return game.getDice2().getValue();}

    public Game getCurrentGame(){

        return games.get(games.size()-1);
    }

    public double getPlayerRanking() {
        double wins = 0.0;
        for (Game game : games) {
            if (game.hasWon()) {
                wins++;
            }
        }
        return wins / games.size()*100;
    }

    public double getFinalScore() {
        double wins = 0.0;
        for (Game game : games) {
            if (game.hasWon()) {
                wins++;
            }
        }
        finalScore=wins / games.size()*100;
        return finalScore;
    }

    @Override
    public String toString() {
        return  name ;
    }
}
