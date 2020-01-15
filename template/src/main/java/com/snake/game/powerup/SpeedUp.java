package com.snake.game.powerup;

import com.badlogic.gdx.graphics.Color;
import com.snake.game.game.Board;
import com.snake.game.game.Snake;
import com.snake.game.game.Timer;

import java.util.TimerTask;

/**
 * Method to increase speed of a snake, as well as adding some points.
 */
public class SpeedUp extends PowerUp {

    public SpeedUp(Board board, Snake snake, int xcoord, int ycoord) {
        super(board, snake, xcoord, ycoord);
    }

    /**
     * Draws speedUp on the board.
     */
    @Override
    public void draw() {
        board.getRend().setColor(Color.RED);
        board.getRend().circle(
                board.getBoardX() + xcoord * board.getTile() + board.getTile() / 2.0f,
                board.getBoardY() + ycoord * board.getTile() + board.getTile() / 2.0f,
                board.getTile());
    }

    /**
     * Increase speed for 30 seconds, give bonus points.
     */
    @Override
    public void handle() {
        Timer<Runnable> gameUpdateTimer = new Timer<>(board::run, 60);
        board.getGame().setGameUpdateTimer(gameUpdateTimer);
        gameUpdateTimer.setActive(true);
        board.getGame().getScore().increment(50);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Timer<Runnable> gameUpdateTimer = new Timer<>(board::run);
                board.getGame().setGameUpdateTimer(gameUpdateTimer);
                gameUpdateTimer.setActive(true);
            }
        };

        java.util.Timer timer = new java.util.Timer("Timer");
        timer.schedule(task, 5000);
    }
}
