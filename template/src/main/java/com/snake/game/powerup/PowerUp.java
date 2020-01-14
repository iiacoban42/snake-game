package com.snake.game.powerup;

import com.snake.game.game.Apple;
import com.snake.game.game.Board;
import com.snake.game.game.Snake;

/**
 * Abstract class.
 */
public abstract class PowerUp {

    public Board board;
    public Snake snake;
    public int xcoord;
    public int ycoord;

    /**
     * Constructor.
     *
     * @param board board
     * @param snake snake
     */
    public PowerUp(Board board, Snake snake) {
        this.board = board;
        this.snake = snake;
        //do {
        xcoord = (int) (board.getGridWidth() * Math.random());
        ycoord = (int) (board.getGridHeight() * Math.random());
        //} while (!snake.collides(xcoord, ycoord));

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
