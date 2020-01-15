package com.snake.game.states;

import com.snake.game.game.Game;
import com.snake.game.screens.ScreenController;

public class EmptyGameState extends GameState {

    public EmptyGameState(ScreenController sc, Game game) {
        super(sc, game);
    }

    @Override
    public void enter() {
//        sc.openScreen(ScreenController.ScreenName.gameScreen);
        game.getGameUpdateTimer().setActive(false);
        game.spawnSprites();
    }
}
