package com.snake.game.states;

import com.snake.game.game.Game;

/**
 * A simple state class for when the game is finished.
 */
public class FinishedGame implements State {

    private transient Game game;

    /**
     * Constructor for FinishedGame.
     */
    public FinishedGame(Game game) {
        this.game = game;
    }

    /**
     * Main method to continuously call while the game is in this state.
     */
    @Override
    public void observe() {
    }

    /**
     * Method to call when the state is entered.
     */
    @Override
    public void enterState() {
        game.gameover();
    }
}