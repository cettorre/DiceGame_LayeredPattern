package com.example.cettorre.dicegame_layeredpattern.application;

import com.example.cettorre.dicegame_layeredpattern.domain.Player;
import java.util.ArrayList;
import java.util.List;


public class GameController {

    List<Player> playersList = new ArrayList<>();

    public Player createPlayer(String name) {

        return new Player(name);
    }

    public void addPlayerToList(Player player) {
        playersList.add(player);
    }

    public List getPlayersList() {

        return playersList;
    }

    public Player getCurrentPLayer(int i) {

        return playersList.get(i);
    }
}
