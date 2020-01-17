package com.snake.game.powerup;

import com.snake.game.game.Board;
import com.snake.game.game.Snake;

/**
 * Abstract class, powerups extend this class with
 * implemented functionality.
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
     * @param ycoord for x-coordinate
     * @param xcoord y-coordinate
     */
    public PowerUp(Board board, Snake snake, int xcoord, int ycoord) {
        this.board = board;
        this.snake = snake;
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
