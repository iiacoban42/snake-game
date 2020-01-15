package com.snake.game.game.powerup;

import com.badlogic.gdx.graphics.Color;
import com.snake.game.game.Game;
import com.snake.game.game.Snake;
import com.snake.game.game.Timer;

import java.util.TimerTask;

/**
 * Method to increase speed of a snake, as well as adding some points.
 */
public class SpeedUp extends PowerUp {

    /**
     * Constructor.
     *
     * @param xPos x-coordinate of position
     * @param yPos y-coordinate of position
     */
    public SpeedUp(int xPos, int yPos) {
        super(xPos, yPos);
    }

    /**
     * Draws speedUp on the board.
     */
    @Override
    public void draw(Game game) {
        game.getBoard().getRend().setColor(Color.RED);
        game.getBoard().getRend().circle(
                game.getBoard().getBoardX() + (xPos + .5f) * game.getBoard().getTile(),
                game.getBoard().getBoardY() + (yPos + .5f) * game.getBoard().getTile(),
                game.getBoard().getTile());
    }

    /**
     * Increase speed for 30 seconds, give bonus points.
     */
    @Override
    public void consume(Game game, Snake snake) {
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
