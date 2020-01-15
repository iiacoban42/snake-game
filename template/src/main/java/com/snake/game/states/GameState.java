package com.snake.game.states;

import com.snake.game.game.Game;
import com.snake.game.screens.ScreenController;

public abstract class GameState {

    protected ScreenController sc;
    protected Game game;

    GameState(ScreenController sc, Game game){
        this.sc = sc;
        this.game = game;
    }

    public abstract void enter();
}
