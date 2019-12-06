package com.snake.game.game;

public class Apple {
    private int x, y;
    private double random;

    public Apple(Board board, Snake snake, double random) {
        this.random = random;
        int xRand = (int) (random * board.gridWidth);
        int yRand = (int) (random * board.gridHeight);
        while (snake.collides(xRand, yRand)) {
            random = Math.random();
            xRand = (int) (random * board.gridWidth);
            yRand = (int) (random* board.gridHeight);
        }
        x = xRand;
        y = yRand;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
         this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void draw(Board board) {
        board.getRend().circle(
                board.getDx() + x * board.getTile() + board.getTile() / 2.0f,
                board.getDy() + y * board.getTile() + board.getTile() / 2.0f,
                board.getTile() / 2.0f);
    }
}
