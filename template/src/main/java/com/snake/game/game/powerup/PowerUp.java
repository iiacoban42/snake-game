package com.snake.game.game.powerup;

import com.snake.game.game.Consumable;
import com.snake.game.game.Game;

/**
 * Abstract class to support any type of power up.
 */
public abstract class PowerUp implements Consumable {

    protected final int xPos;
    protected final int yPos;

    /**
     * Constructor.
     *
     * @param xPos x-coordinate of position
     * @param yPos y-coordinate of position
     */
    public PowerUp(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }
}
