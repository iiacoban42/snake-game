package com.snake.game.powerup;

import com.badlogic.gdx.graphics.Color;
import com.snake.game.game.Board;
import com.snake.game.game.Game;
import com.snake.game.game.Snake;
import com.snake.game.game.Timer;

import java.util.TimerTask;

/**
 * Method to increase speed of a snake, as well as adding some points.
 */
public class SpeedUp extends PowerUp {

    public SpeedUp(Game game, int xcoord, int ycoord) {
        super(game, xcoord, ycoord);
    }

    /**
     * Draws speedUp on the board.
     */
    @Override
    public void draw() {
        game.getBoard().getRend().setColor(Color.RED);
        game.getBoard().getRend().circle(
                game.getBoard().getBoardX() + (xcoord+.5f) * game.getBoard().getTile(),
                game.getBoard().getBoardY() + (ycoord+.5f) * game.getBoard().getTile(),
                game.getBoard().getTile());
    }

    /**
     * Increase speed for 30 seconds, give bonus points.
     */
    @Override
    public void handle() {
        Timer<Runnable> gameUpdateTimer = new Timer<>(game::run, 60);
        game.setGameUpdateTimer(gameUpdateTimer);
        gameUpdateTimer.setActive(true);
        game.getScore().increment(50);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Timer<Runnable> gameUpdateTimer = new Timer<>(game::run);
                game.setGameUpdateTimer(gameUpdateTimer);
                gameUpdateTimer.setActive(true);
            }
        };

        java.util.Timer timer = new java.util.Timer("Timer");
        timer.schedule(task, 5000);
    }
}
