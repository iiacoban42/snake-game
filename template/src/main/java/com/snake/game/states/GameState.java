package com.snake.game.states;

import com.snake.game.game.Game;
import com.snake.game.screens.ScreenController;

public abstract class GameState {

    protected final Game game;

    GameState(Game game) {
        this.game = game;
    }

    public abstract void enter();

    public Game getGame() {
        return game;
    }
}
