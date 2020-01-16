package com.snake.game.states;

import com.snake.game.game.Game;
import com.snake.game.screens.ScreenController;

public class EmptyGameState extends GameState {

    public EmptyGameState(Game game) {
        super(game);
    }

    @Override
    public void enter() {
        game.getGameUpdateTimer().setActive(false);
        game.spawnSprites();
        System.out.println("new");
    }
}
