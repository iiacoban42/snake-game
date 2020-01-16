package com.snake.game.game;

public interface Consumable {

    /**
     * This method is called after Consumable has been consumed.
     */
    void consume(Game game, Snake snake);

    /**
     * Defines how Consumable will be appeared on the screen.
     */
    void draw(Game game);
}
