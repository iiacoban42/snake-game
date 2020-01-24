package com.snake.game.game.powerup;

import com.badlogic.gdx.graphics.Color;
import com.snake.game.game.Game;
import com.snake.game.game.Snake;

/**
 * This powerUp will decrease snake length.
 */
public class LengthPowerUp extends PowerUp {

    private static final int MIN_LENGTH = 4;
    private static final int SIZE_DECREASE = 3;
    private static final int SCORE = 10;

    /**
     * Constructor.
     *
     * @param posX x-coordinate of position
     * @param posY y-coordinate of position
     */
    public LengthPowerUp(int posX, int posY) {
        super(posX, posY);
    }

    /**
     * Draws the LengthPowerUp power-up to the board of the game.
     *
     * @param game game
     */
    @Override
    public void draw(Game game) {
        game.drawMegaApple(posX, posY);
    }

    /**
     * Decrease length.
     */
    @Override
    public void consume(Game game, Snake snake) {
        if (game.getSnake().getLength() > MIN_LENGTH) {
            game.getSnake().addLength(-SIZE_DECREASE);
        }

        game.getScore().increment(SCORE);
    }
}
