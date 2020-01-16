package com.snake.game.states;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.game.Game;
import com.snake.game.screens.ScreenController;

public class ActiveGameState extends GameState {

    public ActiveGameState(Game game) {
        super(game);
    }

    @Override
    public void enter() {
        game.getGameUpdateTimer().setActive(true);
    }

    @Override
    public void draw(ShapeRenderer renderer) {

    }
}
