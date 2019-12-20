package com.snake.game.states;

import com.snake.game.game.Game;

/**
 * Just a simple state class for when the game is active.
 */
public class ActiveGame implements State {

    private transient Game game;

    /**
     * Constructor for ActiveGame.
     */
    public ActiveGame(Game game) {
        this.game = game;
    }

    /**
     * Main method to continuously call while the game is in this state.
     */
    @Override
    public void observe() {
        game.getBoard().draw();
        if (game.getBoard().getSnake().getLength() == 0) {
            game.changeState(new FinishedGame(game));
        }
    }

    /**
     *  method to call when game enters in this state.
     */
    @Override
    public void enterState() {

    }
}