package com.snake.game.powerup;

import com.badlogic.gdx.graphics.Color;
import com.snake.game.game.Board;
import com.snake.game.game.Game;
import com.snake.game.game.Snake;


/**
 * A power-up which spawns in a bunch of apples.
 */
public class MoreApples extends PowerUp {

    private static final int SCORE = 10;
    private static final int APPLES_TO_ADD = 3;

    public MoreApples(Game game, int xcoord, int ycoord) {
        super(game, xcoord, ycoord);
    }

    @Override
    public void draw() {
        game.getBoard().getRend().setColor(Color.BLUE);
        game.getBoard().getRend().circle(
                game.getBoard().getBoardX() + (xcoord+.5f) * game.getBoard().getTile(),
                game.getBoard().getBoardY() + (ycoord+.5f) * game.getBoard().getTile(),
                game.getBoard().getTile());
    }

    /**
     * Adds 3 apples to the board.
     */
    @Override
    public void handle() {
        game.addApples(APPLES_TO_ADD);
        game.getScore().increment(SCORE);
    }

}
