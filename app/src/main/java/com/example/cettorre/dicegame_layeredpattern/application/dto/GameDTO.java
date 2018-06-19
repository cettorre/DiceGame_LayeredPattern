package com.example.cettorre.dicegame_layeredpattern.application.dto;

import com.example.cettorre.dicegame_layeredpattern.domain.Game;

public class GameDTO {

    private int diceValue1;
    private int diceValue2;
    private boolean hasWon;

    public GameDTO(Game game) throws Exception {
        if(game==null)throw new Exception();
        this.diceValue1 = game.getDice1().getValue();
        this.diceValue2 = game.getDice2().getValue();
        this.hasWon=game.hasWon();
    }

    public int getDiceValue1() {
        return diceValue1;
    }

    public int getDiceValue2() {
        return diceValue2;
    }

    public boolean isHasWon() {
        return hasWon;
    }
}
