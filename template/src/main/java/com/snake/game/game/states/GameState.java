package com.snake.game.game.states;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.snake.game.game.Game;

public abstract class GameState {

    protected final Game game;

    /**
     * Create a new game state object - this doesn't put the game in this state.
     *
     * @param game the game to which the state belongs
     */
    GameState(Game game) {
        this.game = game;
    }

    /**
     * Executed once the game enters this state.
     */
    public abstract void enter();

    /**
     * Draw when game is in this state.
     * @param renderer the renderer to use
     */
    public abstract void draw(ShapeRenderer renderer);

    /**
     * What happens on a keypress during this state.
     */
    public abstract void keyPress();

    public Game getGame() {
        return game;
    }


}
