package com.snake.game.game.powerup;

import com.badlogic.gdx.graphics.Color;
import com.snake.game.game.Game;
import com.snake.game.game.Snake;

import java.util.TimerTask;

/**
 * A power-up which will temporarily top the snake from increasing in length.
 */
public class StopGrow extends PowerUp {

    private static final int SCORE = 20;

    /**
     * Constructor.
     *
     * @param posX x-coordinate of position
     * @param posY y-coordinate of position
     */
    public StopGrow(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void draw(Game game) {
        game.drawStopGrow(posX, posY);
    }

    /**
     * Stop growing for 30 seconds.
     */
    @Override
    public void consume(Game game, Snake snake) {
        game.getScore().increment(SCORE);
        game.setStopGrowFlag(true);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                game.setStopGrowFlag(false);
            }
        };

        java.util.Timer timer = new java.util.Timer("Timer");
        timer.schedule(task, 30000);

    }


}
