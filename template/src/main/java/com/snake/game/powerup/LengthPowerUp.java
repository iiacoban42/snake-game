package com.snake.game.powerup;

import com.badlogic.gdx.graphics.Color;
import com.snake.game.game.Board;
import com.snake.game.game.Snake;

/**
 * This powerUp will decrease snake length.
 */
public class LengthPowerUp extends PowerUp {

    private static final int MIN_LENGTH = 4;
    private static final int SIZE_DECREASE = 3;
    private static final int SCORE = 10;

    public LengthPowerUp(Board board, Snake snake, float randomX, float randomY) {
        super(board, snake, randomX, randomY);
    }

    /**
     * Draws length power up on the board.
     */
    @Override
    public void draw() {
        board.getRend().setColor(Color.PINK);

        board.getRend().circle(board.getDx() + xcoord * board.getTile() + board.getTile() / 2.0f,
                board.getDy() + ycoord * board.getTile() + board.getTile() / 2.0f,
                board.getTile());
    }

    /**
     * Decrease length.
     */
    @Override
    public void handle() {
        if (snake.getLength() > MIN_LENGTH) {
            this.snake.addLength(-SIZE_DECREASE);
        }

        board.getScore().increment(SCORE);
    }
}
