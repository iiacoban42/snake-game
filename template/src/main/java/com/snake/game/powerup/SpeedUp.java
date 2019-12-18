package com.snake.game.powerup;

import com.snake.game.game.Board;
import com.snake.game.game.Snake;
import com.snake.game.game.Timer;

/**
 * Method to increase speed of a snake, as well as adding some points.
 */
public class SpeedUp extends PowerUp {

    public SpeedUp(Board board, Snake snake, float random, float randomy) {
        super(board, snake, random, randomy);
    }

    /**
     * Draws speedUp on the board.
     */
    @Override
    public void draw() {
        board.getRend().circle(
                board.getDx() + xcoord * board.getTile() + board.getTile() / 2.0f,
                board.getDy() + ycoord * board.getTile() + board.getTile() / 2.0f,
                board.getTile());
    }

    /**
     * Increase speed for 30 seconds, give bonus points.
     */
    @Override
    public void handle() {
        Timer<Runnable> gameUpdateTimer = new Timer<>(board::run, 30);
        board.setGameUpdateTimer(gameUpdateTimer);
        gameUpdateTimer.setActive(true);
        this.snake.addScore(10);
        TimeHandler timeHandler = new TimeHandler(30000, this);
        timeHandler.start();
    }
}
