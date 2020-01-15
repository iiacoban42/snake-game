package com.snake.game.states;

import com.snake.game.game.Game;
import com.snake.game.screens.ScreenController;

public class ActiveGameState extends GameState {

    public ActiveGameState(ScreenController sc, Game game) {
        super(sc, game);
    }

    @Override
    public void enter() {
        game.getGameUpdateTimer().setActive(true);
    }
}
