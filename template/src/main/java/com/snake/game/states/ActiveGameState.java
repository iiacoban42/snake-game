package com.snake.game.states;

import com.snake.game.game.Game;
import com.snake.game.screens.ScreenController;

public class ActiveGameState extends GameState {

    public ActiveGameState(Game game) {
        super(game);
    }

    @Override
    public void enter() {
        game.getGameUpdateTimer().setActive(true);
        System.out.println("start");
    }
}
