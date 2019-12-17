package com.snake.game.powerup;

import com.snake.game.game.Board;
import com.snake.game.game.Snake;

public abstract class PowerUp {

    public Board board;
    public Snake snake;
    public int xcoord;
    public int ycoord;
    public double random;

    public void PowerUp(Board board, Snake snake, float random, float randomy){
        this.board = board;
        this.snake = snake;
        xcoord = (int) (random * board.getGridHeight());
        ycoord = (int) (randomy * board.getGridHeight());
    }

    public abstract void draw(Board board);

    public abstract void handle(Snake snake);
}
