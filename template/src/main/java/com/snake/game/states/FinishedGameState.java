package com.snake.game.states;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.game.Game;
import com.snake.game.screens.ScreenController;

public class FinishedGameState extends GameState {

    public FinishedGameState(Game game) {
        super(game);
    }

    @Override
    public void enter() {
        game.gameUpdateTimer.setActive(false);
    }

    @Override
    public void draw(ShapeRenderer renderer) {

    }
}
