package com.snake.game.game;

public class Apple {
    private final int x, y;
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


    public void draw(Board board) {
        board.getRend().circle(
                board.getDx() + x * board.getTILE() + board.getTILE() / 2.0f,
                board.getDy() + y * board.getTILE() + board.getTILE() / 2.0f,
                board.getTILE() / 2.0f);
    }
}
