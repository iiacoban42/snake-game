package com.snake.game.powerup;

import com.badlogic.gdx.graphics.Color;
import com.snake.game.game.Board;
import com.snake.game.game.Snake;

/**
 * This is powerUp to give more length and more points than a normal apple.
 */
public class MegaApple extends PowerUp {

    public MegaApple(Board board, Snake snake, float random, float randomy) {
        super(board, snake, random, randomy);
    }

    /**
     * Draws megaApple on the board.
     */
    @Override
    public void draw() {
        board.getRend().setColor(Color.LIME);
        board.getRend().circle(
                board.getDx() + xcoord * board.getTile() + board.getTile() / 2.0f,
                board.getDy() + ycoord * board.getTile() + board.getTile() / 2.0f,
                board.getTile());

    }

    /**
     * Increase length, increase points.
     */
    @Override
    public void handle() {
        this.snake.addLength(5);
        this.snake.addScore(10);
    }
}
