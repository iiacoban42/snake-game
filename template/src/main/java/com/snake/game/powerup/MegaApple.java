package com.snake.game.powerup;

import com.badlogic.gdx.graphics.Color;
import com.snake.game.game.Board;
import com.snake.game.game.Snake;

/**
 * This is powerUp to give more length and more points than a normal apple.
 */
public class MegaApple extends PowerUp {

    private static final int LENGTH_INCREASE = 5;
    private static final int SCORE = 30;

    public MegaApple(Board board, Snake snake, int xcoord, int ycoord) {
        super(board, snake, xcoord, ycoord);
    }

    /**
     * Draws megaApple on the board.
     */
    @Override
    public void draw() {
        board.getRend().setColor(Color.LIME);
        board.getRend().circle(
                board.getBoardX() + xcoord * board.getTile() + board.getTile() / 2.0f,
                board.getBoardY() + ycoord * board.getTile() + board.getTile() / 2.0f,
                board.getTile());

    }

    /**
     * Increase length, increase points.
     */
    @Override
    public void handle() {
        this.snake.addLength(LENGTH_INCREASE);
        board.getGame().getScore().increment(SCORE);
    }
}
