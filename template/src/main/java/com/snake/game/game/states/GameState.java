package com.snake.game.game.states;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.game.Game;

public abstract class GameState {

    protected final Game game;

    GameState(Game game) {
        this.game = game;
    }

    public abstract void enter();

    public abstract void draw(ShapeRenderer renderer);

    public abstract void keyPress();

    public Game getGame() {
        return game;
    }


}
