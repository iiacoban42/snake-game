package com.snake.game.powerup;

import com.badlogic.gdx.graphics.Color;
import com.snake.game.game.Board;
import com.snake.game.game.Snake;

/**
 * This powerUp will decrease snake length.
 */
public class LengthPowerUp extends PowerUp {

    public LengthPowerUp(Board board, Snake snake, float random, float randomy) {
        super(board, snake, random, randomy);
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
        int length = 4;
        if (snake.getLength() > length) {
            this.snake.addLength(-3);
        }

        board.getScore().increment(10);
    }
}
