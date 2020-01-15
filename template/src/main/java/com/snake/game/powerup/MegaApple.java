package com.snake.game.powerup;

import com.badlogic.gdx.graphics.Color;
import com.snake.game.game.Board;
import com.snake.game.game.Game;
import com.snake.game.game.Snake;

/**
 * This is powerUp to give more length and more points than a normal apple.
 */
public class MegaApple extends PowerUp {

    private static final int LENGTH_INCREASE = 5;
    private static final int SCORE = 30;

    public MegaApple(Game game, int xcoord, int ycoord) {
        super(game, xcoord, ycoord);
    }

    /**
     * Draws megaApple on the board.
     */
    @Override
    public void draw() {
        game.getBoard().getRend().setColor(Color.LIME);
        game.getBoard().getRend().circle(
                game.getBoard().getBoardX() + (xcoord+.5f) * game.getBoard().getTile(),
                game.getBoard().getBoardY() + (ycoord+.5f) * game.getBoard().getTile(),
                game.getBoard().getTile());

    }

    /**
     * Increase length, increase points.
     */
    @Override
    public void handle() {
        game.getSnake().addLength(LENGTH_INCREASE);
        game.getScore().increment(SCORE);
    }
}
