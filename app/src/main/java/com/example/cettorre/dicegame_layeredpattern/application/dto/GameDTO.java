package com.example.cettorre.dicegame_layeredpattern.application.dto;

import com.example.cettorre.dicegame_layeredpattern.domain.Game;

public class GameDTO {

    private int diceValue1;
    private int diceValue2;

    public GameDTO(Game game) {
        this.diceValue1 = game.getDice1().getValue();
        this.diceValue2 = game.getDice2().getValue();
    }

    public int getDiceValue1() {
        return diceValue1;
    }

    public int getDiceValue2() {
        return diceValue2;
    }
}
