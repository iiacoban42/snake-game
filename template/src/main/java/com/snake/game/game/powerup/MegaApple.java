package com.snake.game.game.powerup;

import com.badlogic.gdx.graphics.Color;
import com.snake.game.game.Game;
import com.snake.game.game.Snake;

/**
 * This is powerUp to give more length and more points than a normal apple.
 */
public class MegaApple extends PowerUp {

    private static final int LENGTH_INCREASE = 5;
    private static final int SCORE = 30;

    /**
     * Constructor.
     *
     * @param posX x-coordinate of position
     * @param posY y-coordinate of position
     */
    public MegaApple(int posX, int posY) {
        super(posX, posY);
    }

    /**
     * Draws the MegaApple power-up to the board of the game.
     *
     * @param game game
     */
    @Override
    public void draw(Game game) {
        game.drawMegaApple(posX, posY);

    }

    /**
     * Increase length, increase points.
     */
    @Override
    public void consume(Game game, Snake snake) {
        game.getSnake().addLength(LENGTH_INCREASE);
        game.getScore().increment(SCORE);
    }
}
