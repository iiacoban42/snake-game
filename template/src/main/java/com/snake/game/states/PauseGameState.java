package com.snake.game.states;

import com.snake.game.game.Game;
import com.snake.game.screens.ScreenController;

public class PauseGameState extends GameState {

    public PauseGameState(Game game) {
        super(game);
    }

    @Override
    public void enter() {
        game.getGameUpdateTimer().setActive(false);
    }
}
