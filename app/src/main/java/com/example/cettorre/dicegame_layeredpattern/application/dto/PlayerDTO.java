package com.example.cettorre.dicegame_layeredpattern.application.dto;

import com.example.cettorre.dicegame_layeredpattern.domain.Player;

public class PlayerDTO {

    private String playerName;
    private int numberOfRolls;
    private double percentageOfVictories;


    public PlayerDTO(Player player) {
        this.playerName = player.getName();
        this.numberOfRolls = player.getAllGames().size();
        this.percentageOfVictories = player.getPlayerRanking();
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getNumberOfRolls() {
        return numberOfRolls;
    }

    public double getPercentageOfVictories() {
        return percentageOfVictories;
    }

}
