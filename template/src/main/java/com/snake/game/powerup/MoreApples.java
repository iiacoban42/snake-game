package com.snake.game.powerup;

import com.badlogic.gdx.graphics.Color;
import com.snake.game.game.Board;
import com.snake.game.game.Snake;

import java.util.TimerTask;

/**
 * A power-up which spawns in a bunch of apples.
 */
public class MoreApples extends PowerUp {

    private static final int SCORE = 10;
    private static final int APPLES_TO_ADD = 3;

    public MoreApples(Board board, Snake snake, float randomX, float randomY) {
        super(board, snake, randomX, randomY);
    }

    @Override
    public void draw() {
        board.getRend().setColor(Color.BLUE);
        board.getRend().circle(
                board.getDx() + xcoord * board.getTile() + board.getTile() / 2.0f,
                board.getDy() + ycoord * board.getTile() + board.getTile() / 2.0f,
                board.getTile());
    }

    /**
     * Adds 3 apples to the board.
     */
    @Override
    public void handle() {
        board.addApples(APPLES_TO_ADD);
        board.getScore().increment(SCORE);
    }

}
