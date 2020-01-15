package com.snake.game.game;

public interface Consumable {

    /**
     * This method is called after Consumable has been consumed.
     */
    void consume(Game game, Snake snake);

//    /**
//     * This method is called to spawn a Consumable.
//     */
//    void spawn();

    /**
     * Defines how Consumable will be appeared on the screen.
     */
    void draw(Game game);
}
