package com.example.cettorre.dicegame_layeredpattern.domain;

import java.util.ArrayList;
import java.util.List;



public class Player {

    private String name;

    private List<Game> games=new ArrayList<>();

    public Player(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public List<Game> getAllGames() {return games;}

    public boolean rollDices(){
        Game game= new Game();
        games.add(game);
        game.rollDices();
        return game.hasWon();
    }

    public Game getCurrentGame() throws Exception {
        if(games.isEmpty()) throw new Exception();
        return games.get(games.size() - 1);
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
}
