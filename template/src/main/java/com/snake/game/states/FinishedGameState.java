package com.snake.game.states;

import com.snake.game.game.Game;
import com.snake.game.screens.ScreenController;

public class FinishedGameState extends GameState {

    public FinishedGameState(ScreenController sc, Game game) {
        super(sc, game);
    }

    @Override
    public void enter() {


        game.gameUpdateTimer.setActive(false);
    }
}
