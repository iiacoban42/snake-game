package com.snake.game.powerup;

import com.snake.game.game.Apple;
import com.snake.game.game.Board;
import com.snake.game.game.Snake;

/**
 * Abstract class to support any type of power up.
 */
public abstract class PowerUp {

    protected Board board;
    protected Snake snake;
    protected int xcoord;
    protected int ycoord;

    /**
     * Constructor.
     *
     * @param board board
     * @param snake snake
     * @param randomX random for x-coordinate
     * @param randomY random for y-coordinate
     */
    public PowerUp(Board board, Snake snake, float randomX, float randomY) {
        this.board = board;
        this.snake = snake;
        xcoord = (int) (randomX * board.getGridWidth());
        ycoord = (int) (randomY * board.getGridHeight());
    }

    /**
     * Defines how powerUp will be appeared on the screen.
     */
    public abstract void draw();

    /**
     * This method is called after powerUp has been consumed.
     */
    public abstract void handle();

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
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
