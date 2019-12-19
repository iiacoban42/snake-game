package com.snake.game.powerup;

import com.badlogic.gdx.graphics.Color;
import com.snake.game.game.Board;
import com.snake.game.game.Snake;

import java.util.TimerTask;

public class MoreApples extends PowerUp {
    public MoreApples(Board board, Snake snake, float random, float randomy) {
        super(board, snake, random, randomy);
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
     * Adds 5 apples to the board.
     */
    @Override
    public void handle() {
        this.snake.addScore(20);
        board.addApples(3);
    }

}
