 package com.snake.game.game.powerup;

import com.badlogic.gdx.graphics.Color;
import com.snake.game.game.Game;
import com.snake.game.game.Snake;


/**
 * A power-up which spawns in a bunch of apples.
 */
public class MoreApples extends PowerUp {

    private static final int SCORE = 10;
    private static final int APPLES_TO_ADD = 3;

    /**
     * Constructor.
     *
     * @param xPos x-coordinate of position
     * @param yPos y-coordinate of position
     */
    public MoreApples(int xPos, int yPos) {
        super(xPos, yPos);
    }

    /**
     * Draws the MoreApples power-up to the board of the game.
     *
     * @param game game
     */
    @Override
    public void draw(Game game) {
        game.getBoard().getRend().setColor(Color.BLUE);
        game.getBoard().getRend().circle(
                game.getBoard().getBoardX() + (xPos + .5f) * game.getBoard().getTile(),
                game.getBoard().getBoardY() + (yPos + .5f) * game.getBoard().getTile(),
                game.getBoard().getTile());
    }

    /**
     * Adds 3 apples to the board.
     */
    @Override
    public void consume(Game game, Snake snake) {
        game.addApples(APPLES_TO_ADD);
        game.getScore().increment(SCORE);
    }
}
