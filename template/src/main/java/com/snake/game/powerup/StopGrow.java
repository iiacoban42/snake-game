package com.snake.game.powerup;

import com.badlogic.gdx.graphics.Color;
import com.snake.game.game.Board;
import com.snake.game.game.Snake;
import com.snake.game.game.Timer;

import java.util.TimerTask;

/**
 * A power-up which will temporarily top the snake from increasing in length.
 */
public class StopGrow extends PowerUp {

    public StopGrow(Board board, Snake snake, float random, float randomy) {
        super(board, snake, random, randomy);
    }

    @Override
    public void draw() {
        board.getRend().setColor(Color.BLACK);
        board.getRend().circle(
                board.getDx() + xcoord * board.getTile() + board.getTile() / 2.0f,
                board.getDy() + ycoord * board.getTile() + board.getTile() / 2.0f,
                board.getTile());
    }

    /**
     * Stop growing for 30 seconds.
     */
    @Override
    public void handle() {
        this.snake.addScore(20);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {


            }
        };

        java.util.Timer timer = new java.util.Timer("Timer");
        timer.schedule(task, 30000);
    }


}
