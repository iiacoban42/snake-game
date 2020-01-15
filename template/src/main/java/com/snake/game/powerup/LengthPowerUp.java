package com.snake.game.powerup;

import com.badlogic.gdx.graphics.Color;
import com.snake.game.game.Board;
import com.snake.game.game.Game;
import com.snake.game.game.Snake;

/**
 * This powerUp will decrease snake length.
 */
public class LengthPowerUp extends PowerUp {

    private static final int MIN_LENGTH = 4;
    private static final int SIZE_DECREASE = 3;
    private static final int SCORE = 10;

    public LengthPowerUp(Game game, int xcoord, int ycoord) {
        super(game, xcoord, ycoord);
    }

    /**
     * Draws length power up on the board.
     */
    @Override
    public void draw() {
        game.getBoard().getRend().setColor(Color.PINK);
        game.getBoard().getRend().circle(
                game.getBoard().getBoardX() + (xcoord+.5f) * game.getBoard().getTile(),
                game.getBoard().getBoardY() + (ycoord+.5f) * game.getBoard().getTile(),
                game.getBoard().getTile());
    }

    /**
     * Decrease length.
     */
    @Override
    public void handle() {
        if (game.getSnake().getLength() > MIN_LENGTH) {
            game.getSnake().addLength(-SIZE_DECREASE);
        }

        game.getScore().increment(SCORE);
    }
}
