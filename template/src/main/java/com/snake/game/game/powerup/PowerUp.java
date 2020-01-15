package com.snake.game.game.powerup;

import com.snake.game.game.Consumable;

/**
 * Abstract class to support any type of power up.
 */
public abstract class PowerUp implements Consumable {

    protected final int posX;
    protected final int posY;

    /**
     * Constructor.
     *
     * @param posX x-coordinate of position
     * @param posY y-coordinate of position
     */
    public PowerUp(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
