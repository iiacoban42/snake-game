package com.snake.game.powerup;

import com.snake.game.game.Board;
import com.snake.game.game.Snake;

/**
 * This powerUp will decrease snake length.
 */
public class LengthPowerUp extends PowerUp {

    public LengthPowerUp(Board board, Snake snake, float random, float randomy){
        super.PowerUp(board, snake, random, randomy);
    }

    /**
     * Draws length power up on the board.
     */
    @Override
    public void draw() {
        board.getRend().ellipse(board.getDx() + xcoord * board.getTile() + board.getTile() / 2.0f,
                board.getDy() + ycoord * board.getTile() + board.getTile() / 2.0f,
                5, 2);
    }

    /**
     * Decrease length.
     */
    @Override
    public void handle() {
        this.snake.addLength(-3);
    }
}
