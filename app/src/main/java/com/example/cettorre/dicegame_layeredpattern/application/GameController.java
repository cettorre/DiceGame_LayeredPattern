package com.example.cettorre.dicegame_layeredpattern.application;

import com.example.cettorre.dicegame_layeredpattern.application.dto.GameDTO;
import com.example.cettorre.dicegame_layeredpattern.application.dto.PlayerDTO;
import com.example.cettorre.dicegame_layeredpattern.domain.Game;
import com.example.cettorre.dicegame_layeredpattern.domain.Player;

public class GameController {

    private static Player player=new Player("Unic Player");

    public PlayerDTO getPlayer() throws Exception {
        return new PlayerDTO(player);
    }

    Game getCurrentGame() throws Exception {
        return player.getCurrentGame();
    }

    public GameDTO playGame() throws Exception {
        player.rollDices();
        return new GameDTO(getCurrentGame());
    }


}
