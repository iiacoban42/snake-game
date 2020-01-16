package com.snake.game.states;

import com.snake.game.game.Game;

/**
 * Just a simple state class for when the game is active.
 */
public class PausedGame implements State {

    private transient Game game;

    /**
     * Constructor for PausedGame.
     */
    public PausedGame(Game game) {
        this.game = game;
    }

    /**
     * Main method to continuously call while the game is in this state.
     */
    @Override
    public void observe() {
        game.getBoard().draw();
    }

    /**
     *  method to call when game enters in this state.
     */
    @Override
    public void enterState() {
        game.changeState(this);
    }
}