package com.snake.game.powerup;

import com.snake.game.game.Board;
import com.snake.game.game.Game;
import com.snake.game.game.Snake;

/**
 * Abstract class to support any type of power up.
 */
public abstract class PowerUp {

    protected Game game;
    protected int xcoord;
    protected int ycoord;

    /**
     * Constructor.
     *
     * @param game game
     * @param ycoord for x-coordinate
     * @param xcoord y-coordinate
     */
    public PowerUp(Game game, int xcoord, int ycoord) {
        this.game = game;
        this.xcoord = xcoord;
        this.ycoord = ycoord;
    }

    /**
     * Defines how powerUp will be appeared on the screen.
     */
    public abstract void draw();

    /**
     * This method is called after powerUp has been consumed.
     */
    public abstract void handle();

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getXcoord() {
        return xcoord;
    }

    public void setXcoord(int xcoord) {
        this.xcoord = xcoord;
    }

    public int getYcoord() {
        return ycoord;
    }

    public void setYcoord(int ycoord) {
        this.ycoord = ycoord;
    }
}
