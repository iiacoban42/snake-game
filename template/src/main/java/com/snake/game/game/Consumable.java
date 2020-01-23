package com.snake.game.game;

public interface Consumable {

    /**
     * This method is called after Consumable has been consumed.
     *
     * @param game the game in which it's consumed
     * @param snake by which snake it's consumed
     */
    void consume(Game game, Snake snake);

    /**
     * Defines how Consumable will be appeared on the screen.
     *
     * @param game to which game this belongs
     */
    void draw(Game game);
}
