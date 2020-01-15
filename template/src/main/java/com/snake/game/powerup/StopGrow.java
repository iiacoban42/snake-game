package com.snake.game.powerup;

import com.badlogic.gdx.graphics.Color;
import com.snake.game.game.Board;
import com.snake.game.game.Game;
import com.snake.game.game.Snake;

import java.util.TimerTask;

/**
 * A power-up which will temporarily top the snake from increasing in length.
 */
public class StopGrow extends PowerUp {

    private static final int SCORE = 20;

    public StopGrow(Game game, int xcoord, int ycoord) {
        super(game, xcoord, ycoord);
    }

    @Override
    public void draw() {
        game.getBoard().getRend().setColor(Color.ORANGE);
        game.getBoard().getRend().circle(
                game.getBoard().getBoardX() + (xcoord+.5f) * game.getBoard().getTile(),
                game.getBoard().getBoardY() + (ycoord+.5f) * game.getBoard().getTile(),
                game.getBoard().getTile());
    }

    /**
     * Stop growing for 30 seconds.
     */
    @Override
    public void handle() {
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
